package test_generator.unmarshaller.types;

import spoon.reflect.declaration.CtType;
import test_generator.unmarshaller.UnmarshalledVariable;
import test_generator.unmarshaller.utils.InitializeMode;
import test_generator.unmarshaller.utils.NamingUtil;

import java.util.Collection;
import java.util.Set;

public class CollectionUnmarshaller extends AbstractUnmarshaller {
    Set<String> variableNames;
    int depth;

    final int DEPTH_THRESHOLD = 5;

    public CollectionUnmarshaller(StringBuilder buf, int depth, Set<String> variableNames) {
        super(buf);
        this.variableNames = variableNames;
        this.depth = depth;
    }

    @Override
    public String instantiate(Object source, CtType staticClazz) {
        Collection collection = (Collection) source;
        if (collection.size() == 0) {
            return "new " + collection.getClass().getSimpleName() + "<>()";
        } else {
            System.out.println("collection: " + source);

            mode = InitializeMode.MULTILINE;
            String objectsType = collection.toArray()[0].getClass().getSimpleName();
            variableName = new NamingUtil(variableNames).collectionName(collection);
            String instantiate = collection.getClass().getSimpleName() + "<" + objectsType + ">" + " " +
                    variableName + " = " + "new " + collection.getClass().getSimpleName() + "<>();";
            return instantiate + "\n" + populate(collection, staticClazz);
        }
    }

    @Override
    public String populate(Object source, CtType staticClazz) {
        Collection collection = (Collection) source;
        StringBuilder sb = new StringBuilder();

        if(depth < DEPTH_THRESHOLD) {
            for (Object item: collection){
                UnmarshalledVariable uv = new UnmarshalledVariable(item, staticClazz);
                sb.append(variableName + ".add(" + uv.getInlineOrVariable(buf, depth + 1, variableNames) + ");\n");
            }
        }
        return sb.toString();
    }
}
