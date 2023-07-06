package test_generator.unmarshaller.utils;

import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.reference.CtVariableReference;
import spoon.reflect.visitor.filter.FieldAccessFilter;
import spoon.reflect.visitor.filter.VariableAccessFilter;
import spoon.support.reflect.code.CtConstructorCallImpl;
import spoon.support.reflect.code.CtFieldWriteImpl;
import spoon.support.reflect.code.CtInvocationImpl;
import spoon.support.reflect.code.CtVariableReadImpl;
import test_generator.SpoonMapper;
import test_generator.unmarshaller.UnmarshalledVariable;

import java.lang.reflect.Field;
import java.util.*;

public class ReflectionSpoonUtil {
    public static Map<CtConstructor, List<CtFieldReference>> valueSort(final HashMap<CtConstructor, List<CtFieldReference>> map) {
        Comparator<CtConstructor> valueComparator = (k1, k2) -> {
            int comp = Integer.compare(map.get(k1).size(), map.get(k2).size());
            if (comp == 0) return 1;
            else return -comp;
        };

        Map<CtConstructor, List<CtFieldReference>> sorted = new TreeMap<>(valueComparator);
        sorted.putAll(map);

        return sorted;
    }

    ReflectionUtil reflectionUtil;

    public ReflectionSpoonUtil(){
        reflectionUtil = new ReflectionUtil();
    }

    public UnmarshalledVariable instantiateRelateToType(Object source, CtType root){
        CtType ctType = root.getFactory().Type().get(source.getClass().getName());
        if(ctType!=null)
            return new UnmarshalledVariable(source, ctType);
        return new UnmarshalledVariable(source, root);
    }

    public ResolvedConstructor resolveConstructor(CtType root, Object object) {
//        Collection<CtFieldReference<?>> fields = aClass.getAllFields();
        CtClass ctClass = (CtClass) root;
        Set<CtConstructor> ctConstructorSet = ctClass.getConstructors();
        ReflectionUtil reflectionUtil = new ReflectionUtil();
        SpoonMapper mapper = new SpoonMapper(root);

        List<Field> notNullFields = reflectionUtil.getNotNullFields(object);
        HashMap<CtFieldReference, Field> mapFields = mapper.mapFields(notNullFields);
        Set<CtFieldReference> unresolvedFields = new HashSet<>(mapper.getFields(notNullFields));

        HashMap<CtConstructor, List<CtFieldReference>> consFieldsMap = new HashMap<>();
        // New Hashmap or sortedHashMap

        // get constructors with the fields that are modified in there
        for (CtConstructor ctConstructor : ctConstructorSet) {
            ArrayList<CtFieldReference> fieldsOfCons =
                    new ArrayList<>(modifiedFieldsOfConstructor(ctConstructor, unresolvedFields));

            consFieldsMap.put(ctConstructor, fieldsOfCons);
        }

        Map sortedMap = valueSort(consFieldsMap);

        for (Object entry : sortedMap.entrySet()) {
            CtConstructor cons = (CtConstructor) ((Map.Entry<?, ?>) entry).getKey();
            ArrayList<CtFieldReference> fields = (ArrayList<CtFieldReference>) ((Map.Entry<?, ?>) entry).getValue();
//            System.out.println("cons: " + cons);
//            System.out.println("fields: " + fields);

            Set<CtParameter> unresolvedParameters = new HashSet<>(cons.getParameters());
            List<ResolvedParameter> resolvedParameters = new ArrayList<>();
//            System.out.println("unresolvedParams before: " + unresolvedParameters);

            for (CtFieldReference field : fields) {
                List<CtAssignment> assignments = getFieldAssignments(cons, field);
                for (CtAssignment assignment : assignments) {
                    // get the line of assignment
                    CtExpression assignmentExp = assignment.getAssignment();
//                    System.out.println("Exp Class: " + assignmentExp.getClass());
                    if (assignmentExp instanceof CtConstructorCallImpl) {
                        CtConstructorCallImpl consCall = (CtConstructorCallImpl) assignmentExp;
                        Field runField = mapFields.get(field);
                        Object fieldObject = reflectionUtil.getFieldValue(object, runField);
                        getResolvedParametersByCall(consCall, unresolvedParameters,resolvedParameters, fieldObject);
                    } else if(assignmentExp instanceof CtVariableReadImpl){
                        CtVariableReadImpl variableRead = (CtVariableReadImpl) assignmentExp;

                        Object fieldObject = reflectionUtil.getFieldValue(object, field.getSimpleName());
                        resolveParameter(variableRead.getVariable(), unresolvedParameters, resolvedParameters, fieldObject);
                    } if(assignmentExp instanceof CtInvocationImpl){
                        CtInvocationImpl invocation = (CtInvocationImpl) assignmentExp;
                        Field runField = mapFields.get(field);
                        Object fieldObject = reflectionUtil.getFieldValue(object, runField);
                        getResolvedParametersByInvoke(invocation, unresolvedParameters, resolvedParameters, fieldObject);
                    }

                    unresolvedFields.remove(field);
                }
            }

//            System.out.println("unresolvedParams after: " + unresolvedParameters);

            if(unresolvedParameters.size() == 0){
                ResolvedConstructor resolvedConstructor = new ResolvedConstructor(cons, resolvedParameters);
                for(CtFieldReference field: unresolvedFields){
                    resolvedConstructor.unresolvedFields.put(field, mapFields.get(field));
                }
//                if(resolvedConstructor.unresolvedFields.size() > 0)
//                    System.out.println("unresolved Fields: " + resolvedConstructor.unresolvedFields);
                return resolvedConstructor;
            }
        }
        return null;
    }
    public void resolveParameter(
            CtVariableReference variable,
            Set<CtParameter> parameters,
            List<ResolvedParameter> resolvedParameters,
            Object object
    ){
        Iterator<CtParameter> i = parameters.iterator();
        while (i.hasNext()){
            CtParameter param = i.next();

            if(variable.getSimpleName().equals(param.getSimpleName())){
                resolvedParameters.add(new ResolvedParameter(param, object));
                i.remove();
            }
        }
    }

    public List<CtFieldReference> modifiedFieldsOfConstructor(CtConstructor constructor, Set<CtFieldReference> fields){
        if(constructor == null)
            return null;

        if(fields == null)
            return null;

        ArrayList<CtFieldReference> fieldsOfCons = new ArrayList<>();

        for(CtFieldReference field: fields){
            if(field == null)
                continue;

            List<CtFieldAccess<?>> elm= constructor.getElements(new FieldAccessFilter(field));
            for(CtFieldAccess el: elm) {
                if(el.getParent() instanceof CtAssignment){
                    fieldsOfCons.add(field);
                    break;
                }
            }
        }

        return  fieldsOfCons;
    }

    public List<CtAssignment> getFieldAssignments(CtConstructor constructor, CtFieldReference field) {
        List<CtAssignment> assignments = new ArrayList<>();
        List<CtFieldAccess<?>> elm = constructor.getElements(new FieldAccessFilter(field));
        for (CtFieldAccess el : elm) {
            if (el.getParent() instanceof CtAssignment) {
                assignments.add((CtAssignment)el.getParent());
            }
        }
        return assignments;
    }

    public List<CtAssignment> getVariableAssignments(CtConstructor constructor, CtVariableReference variable) {
        List<CtAssignment> assignments = new ArrayList<>();
        List<CtVariableAccess<?>> elm = constructor.getElements(new VariableAccessFilter<>(variable));
        for (CtVariableAccess el : elm) {
            if (el.getParent() instanceof CtAssignment) {
                assignments.add((CtAssignment) el.getParent());
            }
        }
        return assignments;
    }

    public List<ArgumentVariable> getVariableOfConstructorCall(CtConstructorCall constructorCall){
        List<ArgumentVariable> variables = new ArrayList<>();
        List<CtExpression> arguments = constructorCall.getArguments();

        int i = 0;
        for (CtExpression argument : arguments) {
            if (argument instanceof CtVariableReadImpl) {
                CtVariableReadImpl variable = (CtVariableReadImpl) argument;
                variables.add(new ArgumentVariable(variable.getVariable(), i));
            }
            i++;
        }
        return variables;
    }

    public CtTypeReference[] getTypesOfArguments(List<CtExpression> expressions){
        CtTypeReference [] arrayArgs = new CtTypeReference[expressions.size()];
        for (int i=0;i<expressions.size();i++){
            System.out.println("typeRef: " + expressions.get(i).getType());
            arrayArgs[i] = expressions.get(i).getType();
        }
        return arrayArgs;
    }

    public void getResolvedParametersByCall (
            CtConstructorCall constructorCall,
            Set<CtParameter> unresolvedParameters,
            List<ResolvedParameter> resolvedParameters,
            Object object){
        List<ArgumentVariable> variables = getVariableOfConstructorCall(constructorCall);
        // getting the calledConstructor
        CtClass type = (CtClass) constructorCall.getType().getTypeDeclaration();
        // convert list of args to array
        System.out.println("cons: " + constructorCall);
        System.out.println("type: " + type.getConstructors());

        CtTypeReference [] arrayArgs = getTypesOfArguments(constructorCall.getArguments());

        CtConstructor calledConstructor = type.getConstructor(arrayArgs);

        List<CtParameter> calledParameters = calledConstructor.getParameters();

        for (ArgumentVariable variable : variables) {
            System.out.println("variable: " + variable.variable);

            CtParameter calledParameter = calledParameters.get(variable.order);
            System.out.println("calledParam " + calledParameter);
            List<CtAssignment> calledAssignments = getVariableAssignments(calledConstructor, calledParameter.getReference());

            for(CtAssignment cAssingment: calledAssignments){
                if(cAssingment.getAssigned() instanceof CtFieldWriteImpl){
                    CtFieldReference field = ((CtFieldWriteImpl) cAssingment.getAssigned()).getVariable();
                    Object fieldObject = reflectionUtil.getFieldValue(object, field.getSimpleName());
                    resolveParameter(variable.variable, unresolvedParameters, resolvedParameters, fieldObject);

                    System.out.println("object: "+ fieldObject);
                }
            }

        }
    }

    public void getResolvedParametersByInvoke (
            CtInvocationImpl invocation,
            Set<CtParameter> unresolvedParameters,
            List<ResolvedParameter> resolvedParameters,
            Object object){
        // convert list of args to array

        if(object instanceof Collection<?>) {
            List objectList = ((List) object);
            if(objectList.size() > 0)
                object = objectList.get(0);
        }


        for(Object argObj :invocation.getArguments()){
            CtExpression arg = (CtExpression) argObj;
            if (arg instanceof CtConstructorCallImpl) {
                CtConstructorCallImpl consCall = (CtConstructorCallImpl) arg;
                getResolvedParametersByCall(consCall, unresolvedParameters,resolvedParameters, object);
            }
        }
    }

    public String getFieldSetter(CtType staticClazz, CtField stField, String fieldName, Object object, StringBuilder buf, int depth, Set<String> variableNames, String variable){
        if(stField == null)
            return null;

//        System.out.println("ObjectVal: " + object);
//        System.out.println("ObjectType: " + object.getClass());
//
//        System.out.println("BufferValue: " + buf);


        if(stField.isPublic()){
            UnmarshalledVariable uv = new UnmarshalledVariable(object, staticClazz);
            String fieldValue = uv.getInlineOrVariable(buf, depth, variableNames);

            return new FieldSetter(fieldName, FieldSetter.FieldSetterType.PUBLIC, fieldValue, variable).toString();
        } else{
            String setterName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);

//            System.out.println("setterName: " + setterName);
            CtMethod stMethod = getCtMethod(staticClazz, setterName);
            if(stMethod != null){
                UnmarshalledVariable uv = new UnmarshalledVariable(object, staticClazz);
                String fieldValue = uv.getInlineOrVariable(buf, depth, variableNames);
                return new FieldSetter(setterName, FieldSetter.FieldSetterType.SET, fieldValue, variable).toString();
            } else {
                setterName = "add" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1, fieldName.length()-1);
                stMethod = getCtMethod(staticClazz, setterName);
                if(stMethod != null){
                    Collection collection = (Collection) object;
                    StringBuilder sb = new StringBuilder();
                    for (Object item: collection){
                        UnmarshalledVariable uv = new UnmarshalledVariable(item, staticClazz);
                        FieldSetter fieldSetter = new FieldSetter(setterName, FieldSetter.FieldSetterType.ADD, uv.getInlineOrVariable(buf, depth, variableNames), variable);
                        sb.append(fieldSetter);
                    }
                    return sb.toString();
                }
            }

//            System.out.println("StMethod: " + stMethod);
//            if(stMethod != null && !stMethod.isPrivate()) {
//
//            }
        }
        return null;
    }

    private CtMethod getCtMethod(CtType staticClazz, String name) {
        Set<CtMethod> allMethods = staticClazz.getAllMethods();
        CtMethod stMethod = null;
        for(CtMethod method: allMethods){
            if (method.getSimpleName().equals(name)) {
                stMethod = method;
                break;
            }
        }
        return stMethod;
    }
}
