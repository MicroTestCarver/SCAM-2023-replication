package test_generator;

import parser.Arg;
import parser.ArgCollection;
import parser.LeafMethod;
import parser.NodeMethod;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestMethodGenerator {

    CombineClazz clazz;

    Set<Arg> initialFields;

    public TestMethodGenerator(CombineClazz clazz, Set<Arg> initialFields){
        this.clazz = clazz;
        this.initialFields = initialFields;
    }

    private String setDifferentFields(NodeMethod method, Set<Arg> initialFields, Set<String> variableNames){
        StringBuilder sb = new StringBuilder();

        for(Arg field: method.getFields()){
            // that argument didn't be initialized in the test fixture
            if(!initialFields.contains(field)){
                String initField = clazz.setSubjectField(field,variableNames);
                if(initField != null)
                    sb.append(initField);
            }
        }
        return sb.toString();
    }

    private String mockFields(NodeMethod method, Set<String> variableNames){
        StringBuilder sb = new StringBuilder();
        Map<LeafMethod, Arg> mockableFieldsAndMethods = method.methodsBasedOnFields();

        for (Map.Entry<LeafMethod, Arg> entry: mockableFieldsAndMethods.entrySet()){
            String mockedField = mockField(entry.getKey(), entry.getValue(), variableNames);
            if(mockedField != null)
                sb.append(mockedField);
        }

        return sb.toString();
    }

    public String mockField(LeafMethod method, Arg field, Set<String> variableNames){
        StringBuilder buffer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tgiven(" + field.getKey() + "." + method.getMethodName() + "(");
        clazz.invokeMethod(buffer, sb, method.getArgs(), variableNames);
        sb.append(")).willReturn(");
        ArgCollection returnField = new ArgCollection();
        returnField.add(method.getReturnField());
        clazz.invokeMethod(buffer, sb, returnField, variableNames);
        sb.append(");");
        buffer.append(sb);

        return buffer.toString();
    }

    public String invokeMUT(NodeMethod method, Set<String> variableNames){
        StringBuilder buffer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t" + method.getReturnField().getShortTypeWithParent() + " " + method.methodName + " = subject." + method.methodName + "(");
        clazz.invokeMethod(buffer, sb, method.getArgs(), variableNames);
        sb.append(");");
        buffer.append(sb);

        return buffer.toString();
    }

    public String testMethod(NodeMethod method) {
        Set<String> variableNames = new HashSet<>();

        AssertionGenerator assertionGenerator = new AssertionGenerator(clazz);
        StringBuilder sb = new StringBuilder();
        String differentFields = setDifferentFields(method, this.initialFields, variableNames);
        String mockFields = mockFields(method, variableNames);

        if(!differentFields.isEmpty()){
            sb.append(differentFields);
            sb.append("\n\n");
        }
        if(!mockFields.isEmpty()) {
            sb.append(mockFields);
            sb.append("\n\n");
        }
        sb.append(invokeMUT(method, variableNames));
        sb.append("\n\n");
        sb.append(assertionGenerator.assertion(method, variableNames));

        return sb.toString();
    }
}
