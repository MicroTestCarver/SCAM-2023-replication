package parser;

import java.util.Objects;
import java.util.Set;

public class Arg {
    public String key;
    public String value;
    public String type;
    public String hash;

    public Boolean serialized;
    public Object serializedValue;
    public int index;
    public boolean isPrimitive;
    public boolean isInterface;
    private ArgType argType;

    public Set<Arg> fields;

    public Arg(String key, String value){
        this.key = key;
        this.value = value;
        this.argType = ArgType.ARG;
    }

    public Arg(String key, String value, String type){
        this.key = key;
        this.value = value;
        this.type = type;
        this.argType = ArgType.ARG;
    }

    public Arg(String key, String value, String type, ArgType argType){
        this.key = key;
        this.value = value;
        this.type = type;
        this.argType = argType;
    }

    public Arg(String value){
        this.value = value;
    }

    public Arg(ArgType argType){
        this.argType = argType;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public ArgType getArgType() {
        return this.argType;
    }

    public boolean isField() {
        return this.argType == ArgType.FIELD;
    }
    public boolean isArg() {
        return this.argType == ArgType.ARG;
    }

    public boolean isReturn() {
        return this.argType == ArgType.RETURN;
    }

    public boolean isCallback() {
        return this.argType == ArgType.CALLBACK;
    }

    public String getType() {
        return type;
    }

    public String getShortTypeWithParent() {
        String[] names = type.split("\\.");
        String name = names[names.length - 1];
        return name.replaceAll("\\$", "\\.");
    }

    public String getShortType() {
        String name = getShortTypeWithParent();
        String[] names = name.split("\\.");
        return names[names.length - 1];
    }

    public boolean isPrimitiveType(){
        ParserUtils parserUtils = new ParserUtils();
        return parserUtils.isPrimitiveType(type);
    }

    @Override
    public int hashCode(){
        return Objects.hash(key, value);
    }

    @Override
    public String toString()
        {
            return argType + ": Name<" + this.key + "> Type<" + this.type + "> Object<" + this.value + ">" ;
        }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Arg arg = (Arg) obj;
        return Objects.equals(key, arg.key) && Objects.equals(value, arg.value);
    }

    public Object getActualValue(){
        if(this.serialized)
            return serializedValue;
        else
            return getValue();
    }

    enum ArgType {
        FIELD,
        ARG,
        RETURN,
        CALLBACK
    }
}
