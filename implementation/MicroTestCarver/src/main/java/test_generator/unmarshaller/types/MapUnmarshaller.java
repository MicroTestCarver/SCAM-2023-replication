package test_generator.unmarshaller.types;

import spoon.reflect.declaration.CtType;
import test_generator.unmarshaller.UnmarshalledVariable;
import test_generator.unmarshaller.utils.InitializeMode;
import test_generator.unmarshaller.utils.NamingUtil;

import java.util.Map;
import java.util.Set;

public class MapUnmarshaller extends AbstractUnmarshaller {

    Set<String> variableNames;
    int depth;

    final int DEPTH_THRESHOLD = 5;

    public MapUnmarshaller(StringBuilder buf, int depth, Set<String> variableNames) {
        super(buf);
        this.variableNames = variableNames;
        this.depth = depth;
    }

    @Override
    public String instantiate(Object source, CtType staticClazz) {

        Map map = (Map) source;
        if (map.size() == 0) {
            return "new " + map.getClass().getSimpleName() + "<>()";
        } else {
            System.out.println("collection: " + source);

            mode = InitializeMode.MULTILINE;
            String keyType = map.keySet().toArray()[0].getClass().getSimpleName();
            String valueType = map.values().toArray()[0].getClass().getSimpleName();
            variableName = new NamingUtil(variableNames).mapName(map);
            String instantiate = map.getClass().getSimpleName() + "<" + keyType + ", " + valueType + ">" + " " +
                    variableName + " = " + "new " + map.getClass().getSimpleName() + "<>();";
            return instantiate + "\n" + populate(map, staticClazz);
        }
    }

    @Override
    public String populate(Object source, CtType staticClazz) {
        Map map = (Map) source;
        StringBuilder sb = new StringBuilder();
        if(depth < DEPTH_THRESHOLD) {
            for (Object item : map.entrySet()) {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) item;
                UnmarshalledVariable uvKey = new UnmarshalledVariable(entry.getKey(), staticClazz);
                UnmarshalledVariable uvValue = new UnmarshalledVariable(entry.getValue(), staticClazz);
                sb.append(variableName + ".put(" + uvKey.getInlineOrVariable(buf, depth + 1, variableNames) + ", " + uvValue.getInlineOrVariable(buf, depth + 1, variableNames) + ");\n");
            }
        }
        return sb.toString();
    }
}
