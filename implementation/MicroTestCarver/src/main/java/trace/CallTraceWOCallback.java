package trace;

import org.openjdk.btrace.core.BTraceUtils;
import org.openjdk.btrace.core.annotations.*;
import org.openjdk.btrace.core.types.AnyType;

import static org.openjdk.btrace.core.BTraceUtils.*;

@BTrace(trusted = true)
public class CallTraceWOCallback {

    final static String SERIALIZE_TYPE = "xml";
    final static String classesScope = "/^(?!java.util.*|org.springframework.data.domain.*|java.lang.String|(.*)(\\$\\$EnhancerBySpringCGLIB\\$\\$))(.*)/";
    @OnMethod(
            clazz = "${packageName}/",
            method = "${methodName}/",
            location = @Location(Kind.ENTRY)
    )
    public static void onMethodEntry(@Self Object o, @ProbeClassName String pcn, @ProbeMethodName(fqn = true) String pmn, AnyType... args) {
        print(Strings.strcat(pmn, ":{"));
        printDetailedArray("Args", SERIALIZE_TYPE, args);
        if (o != null) {
            printDetailedFields(o, SERIALIZE_TYPE);
        }
    }

    @OnMethod(
            clazz = "${packageName}/",
            method = "${methodName}/",
            location = @Location(value = Kind.CALL, clazz = classesScope, method = "/.*/", where = Where.BEFORE)
    )
    public static void onMethodCall(@TargetInstance Object instance, AnyType arg1) {
//        print("Hi Before1");
        Object[] objects = new Object[1];
        try {
            objects[0] = arg1;
        } catch (NullPointerException e){}
        if (instance != null) {
//            print(instance);
            printDetailedArray("Args", SERIALIZE_TYPE, objects);
        }
    }
    @OnMethod(
            clazz = "${packageName}/",
            method = "${methodName}/",
            location = @Location(value = Kind.CALL, clazz = classesScope, method = "/.*/", where = Where.BEFORE)
    )
    public static void onMethodCall(@TargetInstance Object instance, AnyType arg1, AnyType arg2) {
//        print("Hi Before2");
        Object[] objects = new Object[2];
        try {
            objects[0] = arg1;
        } catch (NullPointerException e){}
        try {
            objects[1] = arg2;
        } catch (NullPointerException e){}
//        print("Hi After2");
        if (instance != null)
            printDetailedArray("Args", SERIALIZE_TYPE, objects);
//            printArray(new Object[]{arg1, arg2});
    }

    @OnMethod(
            clazz = "${packageName}/",
            method = "{methodName}/",
            location = @Location(value = Kind.CALL, clazz = classesScope, method = "/.*/", where = Where.BEFORE)
    )
    public static void onMethodCall(@TargetInstance Object instance, AnyType arg1, AnyType arg2, AnyType arg3) {
//        print("Hi Before3");
        Object[] objects = new Object[3];
        try {
            objects[0] = arg1;
        } catch (NullPointerException e){}
        try {
            objects[1] = arg2;
        } catch (NullPointerException e){}
        try {
            objects[2] = arg3;
        } catch (NullPointerException e){}
//        print("Hi After3");
        if (instance != null)
            printDetailedArray("Args", SERIALIZE_TYPE, objects);
    }

    @OnMethod(
            clazz = "${packageName}/",
            method = "${methodName}/",
            location = @Location(value = Kind.CALL, clazz = classesScope, method = "/.*/")
    )
    public static void onMethodCall(@TargetInstance Object instance, AnyType arg1, AnyType arg2, AnyType arg3, AnyType arg4) {
        Object[] objects = new Object[4];
        try {
            objects[0] = arg1;
        } catch (NullPointerException e){}
        try {
            objects[1] = arg2;
        } catch (NullPointerException e){}
        try {
            objects[2] = arg3;
        } catch (NullPointerException e){}
        try {
            objects[3] = arg4;
        } catch (NullPointerException e){}
        if (instance != null)
            printDetailedArray("Args", SERIALIZE_TYPE, arg1, arg2, arg3, arg4);
    }

    @OnMethod(
            clazz = "${packageName}/",
            method = "${methodName}/",
            location = @Location(value = Kind.CALL, clazz = classesScope, method = "/.*/")
    )
    public static void onMethodCall(@TargetInstance Object instance, AnyType arg1, AnyType arg2, AnyType arg3, AnyType arg4, AnyType arg5) {
        Object[] objects = new Object[5];
        try {
            objects[0] = arg1;
        } catch (NullPointerException e){}
        try {
            objects[1] = arg2;
        } catch (NullPointerException e){}
        try {
            objects[2] = arg3;
        } catch (NullPointerException e){}
        try {
            objects[3] = arg4;
        } catch (NullPointerException e){}
        try {
            objects[4] = arg5;
        } catch (NullPointerException e){}
        if (instance != null)
            printDetailedArray("Args", SERIALIZE_TYPE, arg1, arg2, arg3, arg4, arg5);
    }

    @OnMethod(
            clazz = "${packageName}/",
            method = "${methodName}/",
            location = @Location(value = Kind.CALL, clazz = classesScope, method = "/.*/")
    )
    public static void onMethodCall(@TargetInstance Object instance, AnyType arg1, AnyType arg2, AnyType arg3, AnyType arg4, AnyType arg5, AnyType arg6) {
        Object[] objects = new Object[6];
        try {
            objects[0] = arg1;
        } catch (NullPointerException e){}
        try {
            objects[1] = arg2;
        } catch (NullPointerException e){}
        try {
            objects[2] = arg3;
        } catch (NullPointerException e){}
        try {
            objects[3] = arg4;
        } catch (NullPointerException e){}
        try {
            objects[4] = arg5;
        } catch (NullPointerException e){}
        try {
            objects[5] = arg6;
        } catch (NullPointerException e){}
        if (instance != null)
            printDetailedArray("Args", SERIALIZE_TYPE, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @OnMethod(
            clazz = "${packageName}/",
            method = "${methodName}/",
            location = @Location(value = Kind.CALL, clazz = classesScope, method = "/.*/", where = Where.BEFORE)
    )
    public static void onMethodCall(@Self Object self, @TargetInstance Object instance, @TargetMethodOrField(fqn = true) String method) {
        if (instance != null) {
            print(method + "[" + Integer.toHexString(BTraceUtils.identityHashCode(instance)) + "]");
        }
    }

    @OnMethod(
            clazz = "${packageName/",
            method = "${methodName}/",
            location = @Location(Kind.RETURN)
    )
    public static void onMethodReturn(@Self Object o, @ProbeClassName String pcn, @ProbeMethodName String pmn, @Duration long d) {
        print("}:");
    }
    @OnMethod(
            clazz = "${packageName}/",
            method = "${methodName}/",
            location = @Location(Kind.RETURN)
    )
    public static void onMethodReturnWithCallback(@Return AnyType callbackData) {
        if(callbackData != null)
            printDetailedObject("Return", SERIALIZE_TYPE, callbackData);
    }
}
