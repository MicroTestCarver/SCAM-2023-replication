package test_generator.unmarshaller.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

import static java.util.Arrays.asList;


/**
 * This class provides set of reflection call methods for the result pojo.
 */
public class ReflectionUtil {

    private static final List<String> IGNORED_PACKAGES = asList("java.lang", "java.math", "java.util");
    private static final Map<Class<?>, Class<?>> WRAPPER_TYPE_MAP;
    static {
        WRAPPER_TYPE_MAP = new HashMap<Class<?>, Class<?>>(16);
        WRAPPER_TYPE_MAP.put(Integer.class, int.class);
        WRAPPER_TYPE_MAP.put(Byte.class, byte.class);
        WRAPPER_TYPE_MAP.put(Character.class, char.class);
        WRAPPER_TYPE_MAP.put(Boolean.class, boolean.class);
        WRAPPER_TYPE_MAP.put(Double.class, double.class);
        WRAPPER_TYPE_MAP.put(Float.class, float.class);
        WRAPPER_TYPE_MAP.put(Long.class, long.class);
        WRAPPER_TYPE_MAP.put(Short.class, short.class);
        WRAPPER_TYPE_MAP.put(Void.class, void.class);
    }

    public boolean isPrimitiveType(Object source) {
        return WRAPPER_TYPE_MAP.containsKey(source.getClass());
    }

    /**
     * Checks if field is primitive.
     *
     * @param field the field to check
     * @return true if field is primitive
     */
    public boolean isFieldPrimitive(final Field field) {
        return field.getType().isPrimitive();
    }

    /**
     * Checks if the field is an array or list.
     * @param field the field to check.
     * @return true if the field is an array or list.
     */
    public boolean isFieldArrayOrList(final Field field) {
        final Class<?> type = field.getType();
        return type.isArray() || Iterable.class.isAssignableFrom(type);
    }

    /**
     * Gets all type arguments out of a generic.
     * <p>
     * 		For example, it will retrieve String from Map{@literal <}String, Object{@literal >}
     * </p>
     * @param genericType the generic type to insect.
     * @return the array of generic types
     */
    public Class<?>[] geClassArgumentsFromGeneric(final Type genericType) {
        final Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
        final List<Class<?>> actualClassArguments = new ArrayList<>();

        for (Type actualTypeArgument : actualTypeArguments) {
            if (actualTypeArgument instanceof ParameterizedType) {
                actualClassArguments.add((Class) ((ParameterizedType) actualTypeArgument).getRawType());
            } else {
                actualClassArguments.add((Class) actualTypeArgument);
            }
        }
        return actualClassArguments.toArray(new Class[0]);
    }

    /**
     * Set a value into the passed field.
     * @param resultObject the object in which to set the field.
     * @param field the field to set.
     * @param value the value to set.
     * @param <T> the type of the result object.
     * @throws IllegalAccessException if field cannot be set.
     */
    public <T> void setField(final T resultObject, final Field field, final Object value) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(resultObject, value);
        field.setAccessible(false);
    }

    /**
     * Gets the value from a specific field in the passed object.
     * @param resultObject the object to search.
     * @param field the field to get from.
     * @return the value of the field.
     * @throws IllegalAccessException if field cannot be accessed.
     */
    public Object getFieldValue(final Object resultObject, final Field field) {
        try {
            field.setAccessible(true);
            Object fieldVal = field.get(resultObject);
            field.setAccessible(false);
            return fieldVal;
        } catch (IllegalAccessException | InaccessibleObjectException e) {
            return null;
//            throw new RuntimeException(e);
        }
    }

    public Object getFieldValue(final Object resultObject, final String fieldName) {
        for(Field field: getNotNullFields(resultObject)){
            if(field.getName().equals(fieldName)){
                field.setAccessible(true);
                Object fieldVal;
                try {
                    fieldVal = field.get(resultObject);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                field.setAccessible(false);

                return fieldVal;
            }
        }
        return null;
    }

    /**
     * Given a class, return all fields in the entire class hierarchy.
     *
     * @param clazz the class to search.
     * @param <T>   the Class type
     * @return all fields in that class hierarchy
     */
    public <T> Iterable<Field> retrieveAllFields(final Class<T> clazz) {

        return getInjectableFields(getClassHierarchy(clazz));

    }

    /**
     * Checks if given class should have its constituent members unmarshalled. by checking following conditions:
     * 1. class can't be primitive.
     * 2. class can't be interface and can't come from java.lang pkg, java.util
     * 		(eliminates recursive calls in classes like String, Integer, Long..).
     * 3. if class is array, can't be array of primitives.
     * 4. class can't be a map
     *
     * @param clazz a class to check.
     * @return true if class can be used for unmarshalling
     */
    public boolean shouldConstituentMembersBeUnmarshalled(final Class<?> clazz) {

        return !(clazz.isPrimitive() || isNonInterfaceFromIgnoredPackage(clazz) || isArrayOfPrimitiveTypes(clazz)
                || Map.class.isAssignableFrom(clazz));
    }

    private boolean isNonInterfaceFromIgnoredPackage(final Class<?> clazz) {
        final Package pkg = clazz.getPackage();
        return !clazz.isInterface() && pkg != null && isClassFromIgnoredPackage(pkg.getName());
    }

    private boolean isClassFromIgnoredPackage(final String pkg) {
        for (final String ignoredPkg : IGNORED_PACKAGES) {
            if (pkg.startsWith(ignoredPkg)) {
                return true;
            }
        }

        return false;
    }

    private boolean isArrayOfPrimitiveTypes(final Class<?> clazz) {
        return  clazz.isArray() && clazz.getComponentType().isPrimitive();
    }

    private boolean isObjectOfPrimitiveTypes(final Class clazz) {
        return clazz.isPrimitive();
    }

    /*
     * Retrieves current class and all superclasses except Object.
     *
     * @param resultClass leaf class in the hierarchy to scan
     * @return an iterable collection of classes
     */
    private Collection<Class<?>> getClassHierarchy(final Class<?> resultClass) {

        Collection<Class<?>> classes = new ArrayList<>();
        Class<?> klass = resultClass;
        while (klass != null && !Object.class.equals(klass)) {
            classes.add(klass);
            klass = klass.getSuperclass();
        }
        return classes;
    }

    /*
     * Retrieves all fields valid for injection from the given collection of classes.
     */
    private Iterable<Field> getInjectableFields(final Collection<Class<?>> classes) {
        List<Field> injectableFields = new ArrayList<>();
        for (Class<?> clazz : classes) {
            Collections.addAll(injectableFields, clazz.getDeclaredFields());
        }
        return injectableFields;
    }

    public List<Field> getNotNullFields(final Object object){
        Class rootClazz = object.getClass();
        List<Field> fields = new ArrayList<>();

        for(Class clazz: getClassHierarchy(rootClazz)){
            for(Field field: clazz.getDeclaredFields()){
                Object fieldValue = getFieldValue(object, field);
                if(fieldValue != null){
                    fields.add(field);
                }
            }
        }

        return fields;
    }
}