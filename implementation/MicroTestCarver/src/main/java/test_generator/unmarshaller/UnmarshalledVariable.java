package test_generator.unmarshaller;

import org.hibernate.Hibernate;
import parser.Arg;
import spoon.reflect.declaration.CtType;
import test_generator.unmarshaller.types.*;
import test_generator.unmarshaller.utils.InitializeMode;
import test_generator.unmarshaller.utils.NamingUtil;
import test_generator.unmarshaller.utils.ReflectionUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class UnmarshalledVariable {

    CtType root;
    Object source;
    Arg arg;
    UnmarshalMode mode;
    InitializeMode initMode = InitializeMode.INLINE;

    String variableName;

    public UnmarshalledVariable(Arg arg, CtType root){
        this.root = root;
        this.arg = arg;

        if(arg.serialized){
            this.source = this.arg.serializedValue;
            this.mode = UnmarshalMode.DESERIALIZE;
            settingCtType(this.root);
        } else {
            if(arg.value.contains("@")){
                this.mode = UnmarshalMode.GUESS;
            } else {
                this.mode = UnmarshalMode.TO_STRING;
            }
        }
    }

    public UnmarshalledVariable(Object source, CtType root){
        this.root = root;
        this.source = source;
        this.mode = UnmarshalMode.DESERIALIZE;
        settingCtType(this.root);
    }

    private void settingCtType(CtType root){
        CtType ctType = root.getFactory().Type().get(source.getClass().getName());
        if(ctType!=null)
            this.root = ctType;
    }

    public String unmarshal(StringBuilder buf, int depth, Set<String> variableNames){
        if(mode.equals(UnmarshalMode.DESERIALIZE)){
            return unmarshalDeserialize(buf, depth, variableNames);
        } else if (mode.equals(UnmarshalMode.TO_STRING)){
            return unmarshalToString(buf);
        } else if (mode.equals(UnmarshalMode.GUESS)){
            return unmarshalGuess(buf, variableNames);
        }
        return null;
    }

    private String unmarshalDeserialize(StringBuilder buf, int depth, Set<String> variableNames){
        ReflectionUtil util = new ReflectionUtil();

        if(source instanceof String) {
            return new StringUnmarshaller().unmarshalString((String) source);
        } else if(util.isPrimitiveType(source)) {
            return source.toString();
        } if (source instanceof org.hibernate.collection.internal.PersistentBag){
            Hibernate.initialize(source);
        } if (source instanceof Collection<?>){
            CollectionUnmarshaller unmarshaller = new CollectionUnmarshaller(buf, depth, variableNames);
            String unmarshalString = unmarshaller.unmarshalString(source, root);
            if(unmarshaller.isMultiline()){
                initMode = InitializeMode.MULTILINE;
                variableName = unmarshaller.getVariableName();
            }
            return unmarshalString;
        } if (source instanceof Map<?,?>){
            MapUnmarshaller unmarshaller = new MapUnmarshaller(buf, depth, variableNames);
            String unmarshalString = unmarshaller.unmarshalString(source, root);
            if(unmarshaller.isMultiline()){
                initMode = InitializeMode.MULTILINE;
                variableName = unmarshaller.getVariableName();
            }
            return unmarshalString;
        } else if(source instanceof Optional){
            OptionalUnmarshaller unmarshaller = new OptionalUnmarshaller(buf, depth, variableNames);
            return unmarshaller.unmarshalString(source, root);
        } else if(source.getClass().isEnum()){
            EnumUnmarshaller unmarshaller = new EnumUnmarshaller(buf);
            return unmarshaller.unmarshalString(source, root);
        } else if(source instanceof LocalDate){
            DateUnmarshaller unmarshaller = new DateUnmarshaller(buf);
            return unmarshaller.unmarshalString(source, root);
        } else if(source instanceof Locale){
            LocaleUnmarshaller unmarshaller = new LocaleUnmarshaller(buf);
            return unmarshaller.unmarshalString(source, root);
        } else if(source instanceof BigDecimal){
            BigDecimalUnmarshaller unmarshaller = new BigDecimalUnmarshaller(buf);
            return unmarshaller.unmarshalString(source, root);
        } else {
            ReflectionUnmarshaller unmarshaller = new ReflectionUnmarshaller(buf, depth, variableNames);
            String unmarshalString = unmarshaller.unmarshalString(source, root);
            if(unmarshaller.isMultiline()){
                initMode = InitializeMode.MULTILINE;
                variableName = unmarshaller.getVariableName();
            }
            return unmarshalString;
        }
    }

    public String getInlineOrVariable(){
        StringBuilder buf = new StringBuilder();
        HashSet<String> variableNames = new HashSet<>();
        return getInlineOrVariable(buf, 1, variableNames);
    }

    public String getInlineOrVariable(StringBuilder buf, int depth, Set<String> variableNames){
        if(source == null)
            return null;

//        System.out.println("Source: " + source);
        System.out.println("Source Class: " + source.getClass());
        System.out.println("Depth: " + depth);
//        System.out.println("isEnum: " + source.getClass().isEnum());

        String unmarshalValue = unmarshal(buf, depth, variableNames);

        if(initMode.equals(InitializeMode.INLINE)){
            return unmarshalValue;
        } else{
            buf.append(unmarshalValue);
            return variableName;
        }
    }

    private String unmarshalToString(StringBuilder buf){
        return new StringUnmarshaller().unmarshalString(this.arg.getValue());
    }

    private String unmarshalGuess(StringBuilder buf, Set<String> variableNames){
        initMode = InitializeMode.MULTILINE;
        variableName = new NamingUtil(variableNames).variableName(source);
        buf.append(source.getClass().getSimpleName() + " " + variableName);
        buf.append(" = ");
        buf.append("new " + arg.getShortType() + "();\n");

        for(Arg field: this.arg.fields){
            buf.append(variableName + "." + field.getKey() + " = " + field.getValue());
        }
        return variableName;
    }

    public Boolean isMultiline(){
        return this.initMode.equals(InitializeMode.MULTILINE);
    }

    enum UnmarshalMode{
        DESERIALIZE,
        TO_STRING,
        GUESS
    }
}
