package test_generator.unmarshaller.types;

import spoon.reflect.declaration.CtType;

import java.math.BigDecimal;

public class BigDecimalUnmarshaller extends AbstractUnmarshaller {
    public BigDecimalUnmarshaller(StringBuilder buf) {
        super(buf);
    }

    @Override
    public String instantiate(Object source, CtType staticClazz) {
        BigDecimal decimal = (BigDecimal) source;
        return "new BigDecimal(\"" + decimal.toString() + "\")";
    }

    @Override
    public String populate(Object source, CtType staticClazz) {
        return null;
    }
}
