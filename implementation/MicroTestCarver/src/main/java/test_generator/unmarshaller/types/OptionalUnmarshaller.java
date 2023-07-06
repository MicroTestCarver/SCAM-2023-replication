package test_generator.unmarshaller.types;

import spoon.reflect.declaration.CtType;
import test_generator.unmarshaller.utils.ReflectionSpoonUtil;
import test_generator.unmarshaller.UnmarshalledVariable;

import java.util.Optional;
import java.util.Set;

public class OptionalUnmarshaller extends AbstractUnmarshaller{
    Set<String> variableNames;
    int depth;

    final int DEPTH_THRESHOLD = 5;

    public OptionalUnmarshaller(StringBuilder buf, int depth, Set<String> variableNames) {
        super(buf);
        this.variableNames = variableNames;
        this.depth = depth;
    }

    @Override
    public String instantiate(Object source, CtType staticClazz) {
        Optional typedSource = (Optional) source;
        if(typedSource.isEmpty()){
            return ("Optional.empty();");
        } else {
            ReflectionSpoonUtil spoonUtil = new ReflectionSpoonUtil();
            UnmarshalledVariable uv = spoonUtil.instantiateRelateToType(typedSource.get(), staticClazz);
            return ("Optional.of(" + uv.getInlineOrVariable(buf, this.depth + 1, variableNames) + ")");
        }
    }

    @Override
    public String populate(Object source, CtType staticClazz) {
        return null;
    }
}
