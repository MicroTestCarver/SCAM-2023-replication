package test_generator.unmarshaller.utils;

import parser.Arg;
import parser.NodeMethod;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NamingUtil {

    Set<String> variableNames;

    public NamingUtil(Set<String> variableNames){
        this.variableNames = variableNames;
    }

    public String collectionName(Collection<?> collection){
        String objectsType = collection.toArray()[0].getClass().getSimpleName();
        String proposedName = toLowerFirst(objectsType) + "s";
        String approvedName = uniqueNameWithNumbers(proposedName);
        variableNames.add(approvedName);
        return approvedName;
    }

    public String mapName(Map<?,?> map){
        String keyType = map.keySet().toArray()[0].getClass().getSimpleName();
        String valueType = map.values().toArray()[0].getClass().getSimpleName();
        String proposedName = toLowerFirst(keyType) + "Mapped" + valueType;
        String approvedName = uniqueNameWithNumbers(proposedName);
        variableNames.add(approvedName);
        return approvedName;
    }

    public String variableName(Object source){
        String proposedName = toLowerFirst(source.getClass().getSimpleName());
        String approvedName = uniqueNameWithNumbers(proposedName);
        variableNames.add(approvedName);
        return approvedName;
    }

    public String testName(NodeMethod method){
        String proposedName = toLowerFirst(method.methodName);
        String approvedName = uniqueNameWithSituation(proposedName, method);
        variableNames.add(approvedName);
        return approvedName + "Test";
    }

    private String uniqueNameWithNumbers(String name){
        String approvedName = name;
        int i = 1;
        while(checkDuplication(approvedName)){
            approvedName = name + "_" + i;
            i++;
        }
        return approvedName;
    }

    private String uniqueNameWithSituation(String name, NodeMethod method){
        String approvedName = name;
        if(checkDuplication(approvedName)){
            approvedName += "Where";
            Iterator<Arg> it = method.getArgs().iterator();
            while(it.hasNext()){
                Arg arg = it.next();
                String argName = removeQuotation(arg.getKey());
                String argValue = removeQuotation(arg.getValue());
                if(argName!=null && !argName.isEmpty() && !argName.equals("null")) {
                    approvedName += capitalize(argName);
                } else if(argValue.length() < 10) {
                    approvedName += capitalize(argValue);
                } else {
                    approvedName += capitalize(arg.getShortType());
                }

                if(!checkDuplication(approvedName))
                    break;

                if(it.hasNext())
                    approvedName += "And";
            }

            if(checkDuplication(approvedName)) {
                approvedName += "Return";
                Arg arg = method.getReturnField();
                String argValue = removeQuotation(arg.getValue());
                if (argValue.length() < 10) {
                    approvedName += capitalize(argValue);
                } else {
                    approvedName += capitalize(arg.getShortType());
                }
            }

            if(checkDuplication(approvedName))
                approvedName = uniqueNameWithNumbers(approvedName);
        }
        return approvedName;
    }

    private String capitalize(String name){
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    private String toLowerFirst(String name){
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }
    private String removeQuotation(String name){
        if(name == null)
            return null;
        return name.replace("\"", "");
    }

    private Boolean checkDuplication(String name){
        return variableNames.contains(name);
    }
}
