package test_generator.unmarshaller.types;

import spoon.reflect.declaration.CtType;

import java.util.Locale;

public class LocaleUnmarshaller extends AbstractUnmarshaller{
    public LocaleUnmarshaller(StringBuilder buf) {
        super(buf);
    }

    @Override
    public String instantiate(Object source, CtType staticClazz) {
        Locale locale = (Locale) source;
        return "Locale." + locale.getDisplayLanguage().toUpperCase();
    }

    @Override
    public String populate(Object source, CtType staticClazz) {
        return null;
    }
}
