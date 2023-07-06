package parser;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.SunUnsafeReflectionProvider;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;
import java.util.*;

public class Parser {

    public String poolDir;
    public InputStream inputStream;

    private String deserializeType;
    private XStream xstream;
    public String time;
    private ParserUtils util;

    private ArrayList<NodeMethod> nodeMethods;
    private ArrayList<NodeMethod> rootNodeMethods;
    private LeafMethod lastMethodClazz;
    private Stack<NodeMethod> stackNodeMethods;
    private Stack<LeafMethod> stackLeafMethods;
    private Arg lastArg;
    private HashMap<String, Clazz> clazzSet;

    private boolean allowDuplication = false;

    public Parser(InputStream inputStream, String poolDir, String desType, boolean duplication) {
        this.inputStream = inputStream;
        this.poolDir = poolDir;
        this.nodeMethods = new ArrayList<>();
        this.rootNodeMethods = new ArrayList<>();
        this.stackNodeMethods = new Stack<>();
        this.stackLeafMethods = new Stack<>();
        this.clazzSet = new HashMap<>();
        util = new ParserUtils();
        this.deserializeType = desType;
        this.allowDuplication = duplication;

        if(deserializeType.equalsIgnoreCase("json")) {
            xstream = new XStream(new SunUnsafeReflectionProvider(), new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
        } else {
            xstream = new XStream(new SunUnsafeReflectionProvider());
        }
        xstream.ignoreUnknownElements();
        xstream.addPermission(AnyTypePermission.ANY);
    }

    public void readLines() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inputStream));
            String line = in.readLine();
            tokenStart(line);

            while ((line = in.readLine()) != null) {
                if (line.contains(":{")) {
                    tokenClazzMethod(line);
                } else if (util.containsAll(line, new String[]{"#", "[", "]"})) {
                    tokenMethod(line);
                } else if (line.contains("Args: [{")) {
                    tokenArg(line);
                }  else if (line.contains("Args: []")) {
                    tokenArgNull(line);
                } else if (line.contains("Fields: [{")) {
                    tokenField(line);
                } else if (line.contains("Return: {")) {
                    tokenReturn(line);
                } else if (line.contains("Callback: {")) {
                    tokenCallback(line);
                } else if (line.equals("}, ]")) {
                    tokenEndArg(line);
                } else if (line.contains("}, {")) {
                    tokenEndNewArg(line);
                } else if (line.contains("}:")) {
                    tokenEndNodeMethod(line);
                }
//                else if (line.contains("}#")) {
//                    tokenEndLeafMethod(line);
//                }
                else if (line.contains("hash: ")) {
                    tokenHash(line);
                } else if (line.contains("index: ")) {
                    tokenIndex(line);
                } else if (line.contains("name: ")) {
                    tokenName(line);
                } else if (line.contains("type: ")) {
                    tokenType(line);
                } else if (line.contains("serialized: ")) {
                    tokenSerialized(line);
                } else if (line.contains("isPrimitive: ")) {
                    tokenIsPrimitive(line);
                } else if (line.contains("isInterface: ")) {
                    tokenIsInterface(line);
                } else if (line.contains("object: ")) {
                    tokenObject(line);
                } else if (line.contains("fields: ")) {
                    tokenFields(line);
                } else if (line.equals("}")) {
                    tokenEndRet(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void visualization() {
        visualizationCalls();
        visualizationClasses();
    }

    public void visualizationCalls() {
        //        System.out.println("rootNodeMethods: " + rootNodeMethods);
        try {
            Writer writer = new FileWriter(new File("./test-output/parse-visualization.md"));
            writer.write("```mermaid\n");
            writer.write("mindmap\n" +
                    "  root((" + rootNodeMethods.get(0).clazz.getPackageName() + "))\n");

            for(NodeMethod root: rootNodeMethods){
                writer.write(root.visualise(2));
            }
            writer.write("```");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void visualizationClasses(){
        try {
            Writer writer = new FileWriter(new File("./test-output/class-visualization.md"));
            writer.write("```mermaid\n");
            writer.write("mindmap\n" +
                    "  root((" + rootNodeMethods.get(0).clazz.getPackageName() + "))\n");

            System.out.println("Clazzs:");
            for(Clazz clazz: clazzSet.values()){
                System.out.println(clazz);
                writer.write(clazz.visualise());
            }
            writer.write("```");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void tokenFields(String line) {
        line = line.substring(12);
        String[] argStrings = splitArgs(line);
        Set<Arg> args = new HashSet<>();
        for (String argString : argStrings) {
//            System.out.println(argString);
            if (!argString.isEmpty() && argString != null) {
                String[] dual = argString.split("=");
                String[] detailedType = dual[0].split(" ");
                String key;
                String type = "class";
                if(detailedType.length == 2){
                    key = detailedType[1];
                } else {
                    type = detailedType[1];
                    key = detailedType[2];
                }
                String value = dual[1];
                args.add(new Arg(key, value, type));
            }
        }
        lastArg.fields = args;
    }

    private void tokenObject(String line) {
        line = line.substring(12, line.length() - 1);
        lastArg.value = line;
    }

    private void tokenIsInterface(String line) {
        line = line.substring(17, line.length() - 1);
        lastArg.isInterface = Boolean.parseBoolean(line);
    }

    private void tokenHash(String line) {
        line = line.substring(10, line.length() - 1);
        lastArg.hash = line;
    }

    private void tokenIndex(String line) {
        line = line.substring(11, line.length() - 1);
        lastArg.index = Integer.parseInt(line);
    }

    private void tokenName(String line) {
        line = line.substring(10, line.length() - 1);
        lastArg.key = line;
    }

    private void tokenType(String line) {
        line = line.substring(10, line.length() - 1);
        lastArg.type = line;
    }

    private void tokenSerialized(String line) {
        line = line.substring(16, line.length() - 1);
        lastArg.serialized = Boolean.parseBoolean(line);
        if(lastArg.serialized){
            String fileName = poolDir + "/" + lastArg.hash + "." + deserializeType;
            InputStream inputStream = this.getClass().getResourceAsStream(fileName);
            System.out.println(fileName);
            lastArg.serializedValue = xstream.fromXML(inputStream);
            System.out.println("Serialized Object: " + lastArg.serializedValue);
        }
    }


    private void tokenIsPrimitive(String line) {
        line = line.substring(16, line.length() - 1);
        lastArg.isPrimitive = Boolean.parseBoolean(line);
    }

    private void tokenEndNewArg(String line) {
        Arg.ArgType argType = lastArg.getArgType();

        addArgsFieldsParams();
//        System.out.println(lastArg);

        Arg arg = new Arg(argType);
        this.lastArg = arg;
    }

    private void tokenEndArg(String line) {
        addArgsFieldsParams();

        if (!(lastMethodClazz instanceof NodeMethod)) {
            stackNodeMethods.peek().addMethodCallee(lastMethodClazz);
        }

//        System.out.println(lastArg);

        lastArg = null;

    }

    private void addArgsFieldsParams(){
        if (lastArg.isField() && (lastMethodClazz instanceof NodeMethod)) {
            // Add a Param to Clazz
            lastMethodClazz.clazz.addParam(lastArg);
            clazzSet.put(lastMethodClazz.clazz.fullName(), lastMethodClazz.clazz);
            // Add a Field to ClazzMethod
            lastMethodClazz.addField(lastArg);
        } else if (lastArg.isArg()) {
            lastMethodClazz.addArg(lastArg);
            if(lastMethodClazz instanceof NodeMethod)
                if(((NodeMethod) lastMethodClazz).isInitMethod)
                    lastMethodClazz.clazz.addArg(lastArg);
        }
    }

    private void tokenEndRet(String line) {
        if (lastArg.isReturn()) {
            NodeMethod nodeMethod = stackNodeMethods.peek();
            nodeMethod.returnField = lastArg;
        } else if (lastArg.isCallback()) {
            LeafMethod leafMethod = stackLeafMethods.pop();
            leafMethod.returnField = lastArg;
        }

//        System.out.println(lastArg);
        lastArg = null;
    }

    private void tokenStart(String line) {
        this.time = line.split("### BTrace Log: ")[0];
    }

    private void tokenClazzMethod(String line) {
        line = line.split(":")[0];

        NodeMethod cm = methodParser(line);
        if(cm.equals(lastMethodClazz)) {
            cm.setReference(lastMethodClazz);
        }
        lastMethodClazz = cm;
        stackNodeMethods.push(cm);
//        System.out.println("class parsed: " + cm);
    }

    private void tokenMethod(String line) {
        LeafMethod lm = methodCallParser(line);
        lastMethodClazz = lm;
        stackLeafMethods.push(lm);
//        System.out.println("method parsed: " + cm);
    }

//    private void tokenStartClazzMethod(String line){
//
//    }

    private void tokenEndNodeMethod(String line) {
        NodeMethod nodeMethod = stackNodeMethods.pop();
        if (!stackNodeMethods.isEmpty())
            stackNodeMethods.peek().addChildren(nodeMethod);
        else
            rootNodeMethods.add(nodeMethod);
//        for(Arg arg: clazz.args){
//            clazz.argTypes.add(arg.type);
//        }

        nodeMethods.add(nodeMethod);
    }

//    private void tokenEndLeafMethod(String line) {
//        LeafMethod clazz = stackLeafMethods.pop();
//    }

    private void tokenField(String line) {
        Arg arg = new Arg(Arg.ArgType.FIELD);
        lastArg = arg;
    }

    private void tokenArg(String line) {
        Arg arg = new Arg(Arg.ArgType.ARG);
        lastArg = arg;
    }

    private void tokenArgNull(String line) {
        if (!(lastMethodClazz instanceof NodeMethod)) {
            stackNodeMethods.peek().addMethodCallee(lastMethodClazz);
        }
    }

    private void tokenReturn(String line) {
        Arg arg = new Arg(Arg.ArgType.RETURN);
        lastArg = arg;
    }

    private void tokenCallback(String line) {
        Arg arg = new Arg(Arg.ArgType.CALLBACK);
        lastArg = arg;
    }

    private String[] splitArgs(String line) {
        line = line.substring(1, line.length() - 2);
        return line.split("([a-zA-Z])+ ([a-zA-Z]|\\.|\\@|\\$|\\d)+ ([a-zA-Z])+=(\\[([a-zA-Z]|\\.|\\@|\\$|\\d|\\s|,)*\\]|([a-zA-Z]|\\.|\\@|\\$|\\d)*), ");
    }

    private LeafMethod methodCallParser(String line) {
        // Example: virtual java.lang.Object java.util.Optional#orElse(java.lang.Object)[Optional[Clear: clear sky]]
        String[] parts = line.split(" ");
        String clazzType = parts[0];
        String methodReturnType = parts[1];

        // split methodName and packages
        // join if there is other spaces in third part
        String[] clazzParts = String.join(" ", Arrays.copyOfRange(parts, 2, parts.length)).split("#");

        // java.util.Optional -> Optional is clazzName, and java.util is packageName
        String[] names = clazzParts[0].split("\\.");
        String clazzName = names[names.length - 1];
        String packageName = String.join(".", Arrays.copyOfRange(names, 0, names.length - 1));

        // Split methodCall and instance by )[
        String[] methodParts = clazzParts[1].split("\\)\\[");

        String methodName;
        String[] argTypes;
        if(methodParts.length > 1) {

            // Split methodName and Args
            String[] methodCalls = methodParts[0].split("\\(");
            methodName = methodCalls[0];
            argTypes = methodCalls[1].split(", ");
        } else{
            argTypes = null;
            methodParts = clazzParts[1].split("\\[");
            methodName = methodParts[0];
            if(methodParts.length>2){
                methodParts[1] = (String) walkFindNotNull(Arrays.asList(methodParts), 1, methodParts.length);
            }
        }

        String instanceObject = methodParts[1].substring(0, methodParts[1].length() - 1);

        Clazz item = findOrCreateClazz(packageName, clazzName);
        item.setType(clazzType);

        LeafMethod method = new LeafMethod(item, methodName, methodReturnType, argTypes, instanceObject, allowDuplication);
        return method;
    }

    private NodeMethod methodParser(String line) {
        String[] parts = line.split(" ");
        String methodView = parts[0];
        String methodReturnType = parts[1];

        String[] names = parts[2].split("#");
        String[] classNames = names[0].split("\\.");

        // Split methodName and Args
        String[] methodCalls = names[1].split("\\(");
        String methodName = methodCalls[0];
        String[] argTypes = null;
        if(methodCalls.length > 1)
            argTypes = methodCalls[1].split(", ");

        String clazzName = classNames[classNames.length - 1];
        String packageName = String.join(".", Arrays.copyOfRange(classNames, 0, classNames.length - 1));
        String clazzKey = packageName + "." + clazzName;

        Clazz item = findOrCreateClazz(packageName, clazzName);

        NodeMethod method = new NodeMethod(item, methodName, allowDuplication);
        method.returnType = methodReturnType;
        if(argTypes != null)
            method.argTypes.addAll(Arrays.asList(argTypes));

        if(methodName.equals("<init>")) {
            method.isInitMethod = true;
            item.initMethod = method;
        }else {
            item.addMethod(method);
        }
        clazzSet.put(clazzKey, item);

        return method;
    }

    Clazz findOrCreateClazz(String packageName, String clazzName) {
        String clazzKey = packageName + "." + clazzName;

        Clazz item = clazzSet.get(clazzKey);
        if (item == null) {
            item = new Clazz(packageName, clazzName);
        }

        return item;
    }

    public HashMap<String, Clazz> getClazzSet() {
        return clazzSet;
    }

    private Object walkFindNotNull(List list, int from, int to){
        for(int i=from; i<to; i++){
            Object object = list.get(i);
            if(object != null){
                if (object.getClass().getTypeName().equals("java.lang.String")){
                    if(!((String) object).isEmpty()){
                        return object;
                    }
                }else {
                    return object;
                }
            }
        }
        return null;
    }
}
