package trace;

import org.openjdk.btrace.core.BTraceUtils;
import org.openjdk.btrace.core.annotations.*;
import org.openjdk.btrace.core.types.AnyType;

import static org.openjdk.btrace.core.BTraceUtils.*;

@BTrace(trusted = true)
public class CallTraceWOArgsCall {

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
    public static void onMethodCall(@Self Object self, @TargetInstance Object instance, @TargetMethodOrField(fqn = true) String method) {
        if (instance != null) {
            print(method + "[" + Integer.toHexString(BTraceUtils.identityHashCode(instance)) + "]");
        }
    }

    @OnMethod(
            clazz = "${packageName}\\..*/",
            method = "${methodName}/",
            location = @Location(value = Kind.CALL, clazz = classesScope, method = "/.*/", where = Where.AFTER)
    )
    public static void onMethodAfterCall(@TargetMethodOrField(fqn = true) String method, @Return AnyType callbackData, @Duration long d, AnyType arg) {
//        String regex = Sys.$("packageName").substring(1) + ".*";
//        String methodName = method.split("#")[0].split(" ")[2];
//        Boolean inPackage = methodName.matches(regex);
        if(callbackData != null)
            printDetailedObject("Callback", SERIALIZE_TYPE, callbackData);
//        if (!inPackage) printDetailedObject("Callback", callbackData);
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
