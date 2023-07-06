package parser;

import java.util.*;

public class LeafMethod {

    public String methodName;

    public ArgCollection args;
    public Set<Arg> fields;
    public Set<String> argTypes;

    public Clazz clazz;

    public Arg returnField;
    public String returnType = "void";
    public String hashObject;

    private boolean allowDuplication = false;

    public LeafMethod(Clazz clazz, String methodName, boolean duplication) {
        this.clazz = clazz;
        this.methodName = methodName;

        this.args = new ArgCollection();
        this.argTypes = new HashSet<>();
        this.fields = new HashSet<>();

        this.allowDuplication = duplication;
    }

    public LeafMethod(Clazz clazz, String methodName, String returnType, String[] argTypes, String hashObject, boolean duplication) {
        this.clazz = clazz;
        this.methodName = methodName;

        this.returnType = returnType;
        this.argTypes = new HashSet<>();
        if(argTypes != null)
            this.argTypes.addAll(Arrays.asList(argTypes));
        this.hashObject = hashObject;

        this.args = new ArgCollection();
        this.fields = new HashSet<>();

        this.allowDuplication = duplication;
    }

    public String fullName(){
        return clazz.fullName() + "." + methodName;
    }

    public String getMethodName(){
        return methodName;
    }

    // return a method with argument types like hello(java.lang.String)
    public String getMethodWithTypes() {
        String string = this.returnType + " " + this.methodName + "(";
        return getArgTypes(string);
    }

    private String getArgTypes(String string) {
        Iterator<String> it = argTypes.iterator();
        while(it.hasNext()){
            String type = it.next();
            string = string.concat(type);
            if(it.hasNext()){
                string = string.concat(", ");
            }
        }
        string = string.concat(")");
        return string;
    }

    public String getFullNameWithTypes() {
        String string = this.returnType + " " + this.fullName() + "(";
        return getArgTypes(string);
    }


    public void addArg(Arg arg){
        this.args.add(arg);
    }

    public void setArgs(Set<Arg> args){
        this.args.addAll(args);
    }

    public ArgCollection getArgs(){
        return args;
    }

    public void addField(Arg arg){
        this.fields.add(arg);
    }

    public void setFields(Set<Arg> args){
        this.fields.addAll(args);
    }

    public Set<Arg> getFields(){
        return fields;
    }

    public Boolean hasReturn(){
        if(returnField!= null){
            return true;
        }
        return false;
    }

    public Arg getReturnField() {
        return returnField;
    }

    @Override
    public String toString(){
        String string = "Class<" + this.clazz.fullName() + "> Method<" + getMethodWithTypes() + ">";
        if(hasReturn())
            string = string.concat(" Return<" + returnField.value + ">");
        return string;
    }

    @Override
    public int hashCode(){
        return Objects.hash(methodName, clazz);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LeafMethod bm = ((LeafMethod) obj);
        boolean check = Objects.equals(methodName, bm.methodName) &&
                Objects.equals(clazz, bm.clazz) &&
                Objects.equals(hashObject, bm.hashObject) &&
                Objects.equals(args, bm.args) &&
                Objects.equals(returnType, bm.returnType);

        if(allowDuplication)
                return check && Objects.equals(returnField, bm.returnField);
        return check;
    }

    public Boolean isInArrayList(ArrayList<?> list){
        for(Object object: list){
            LeafMethod lm = (LeafMethod) object;
            if(getFullNameWithTypes().equals(lm.getFullNameWithTypes()))
                return true;
        }
        return false;
    }

    public String visualise(int indentation){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<indentation;i++)
            sb.append("  ");

        sb.append("(\"" + this.getFullNameWithTypes());
        if(this.hasReturn()){
            sb.append("</br>{"+ this.getReturnField().getValue().replace("\"", "") +"}\")\n");
        } else {
            sb.append("\")\n");
        }

        return sb.toString();
    }

}
