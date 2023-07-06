package test_generator.unmarshaller.utils;

public class FieldSetter {
    public String setterName;
    public FieldSetterType type;
    public String value;
    public String variable;

    public FieldSetter(String setterName, FieldSetterType type, String value, String variableName){
        this.setterName = setterName;
        this.type = type;
        this.value = value;
        this.variable = variableName;
    }

    @Override
    public String toString() {
        if(type.equals(FieldSetterType.PUBLIC)){
            return variable + "." + setterName + " = " + value + ";\n";
        } if(type.equals(FieldSetterType.SET)){
            return variable + "." + setterName + "(" + value + ")" + ";\n";
        } if(type.equals(FieldSetterType.ADD)){
            return variable + "." + setterName + "(" + value + ")" + ";\n";
        }
        return null;
    }
    enum FieldSetterType{
        PUBLIC,
        SET,
        ADD,
        NONE
    }
}
