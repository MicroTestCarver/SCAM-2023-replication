package test_generator.unmarshaller.types;

import spoon.reflect.declaration.CtType;

public class DateUnmarshaller extends AbstractUnmarshaller{

    public DateUnmarshaller(StringBuilder buf) {
        super(buf);
    }

    @Override
    public String instantiate(Object source, CtType staticClazz) {
        return "LocalDate.parse(\""+ source + "\")";
    }

    @Override
    public String populate(Object source, CtType staticClazz) {
        return null;
    }
}
