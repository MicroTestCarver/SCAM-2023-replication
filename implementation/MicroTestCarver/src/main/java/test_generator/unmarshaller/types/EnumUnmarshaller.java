package test_generator.unmarshaller.types;

import spoon.reflect.declaration.CtType;

public class EnumUnmarshaller extends AbstractUnmarshaller{

    public EnumUnmarshaller(StringBuilder buf) {
        super(buf);
    }

    @Override
    public String instantiate(Object source, CtType staticClazz) {
        return source.getClass().getSimpleName() + "." + source;
    }

    @Override
    public String populate(Object source, CtType staticClazz) {
        return null;
    }
}
