package test_generator.unmarshaller.types;

import spoon.reflect.declaration.CtType;
import test_generator.unmarshaller.utils.InitializeMode;

public abstract class AbstractUnmarshaller {

    StringBuilder buf;
    InitializeMode mode = InitializeMode.INLINE;
    String variableName;

    AbstractUnmarshaller(StringBuilder buf){
        this.buf = buf;
    }

    public String unmarshalString(Object source,  CtType staticClazz){
        String instantiate = instantiate(source, staticClazz);
//        buf.append("\n");
//        buf.append(populate(source));
        return instantiate;
    }

    public abstract String instantiate(Object source, CtType staticClazz);

    public abstract String populate(Object source, CtType staticClazz);

    public Boolean isMultiline(){
        return this.mode.equals(InitializeMode.MULTILINE);
    }

    public String getVariableName() {
        return variableName;
    }

    // canUnmarshal
}
