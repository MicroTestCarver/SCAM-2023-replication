package trace_samples.example;

import org.openjdk.btrace.core.annotations.BTrace;
import org.openjdk.btrace.core.annotations.OnMethod;

import static org.openjdk.btrace.core.BTraceUtils.println;

@BTrace
public class HelloWorldTrace {
    @OnMethod(clazz="extra.HelloWorld", method="/.*/")
    public static void onMethod() {
        println("Hello from method");
    }
}