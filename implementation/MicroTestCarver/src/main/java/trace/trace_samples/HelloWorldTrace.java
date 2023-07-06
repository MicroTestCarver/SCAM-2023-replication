package samples;

import org.openjdk.btrace.core.annotations.*;

import static org.openjdk.btrace.core.BTraceUtils.*;
import static org.openjdk.btrace.core.BTraceUtils.Strings.str;


@BTrace
public class HelloWorldTrace {
    @OnMethod(
            clazz = "samples.HelloWorld",
            location = @Location(value = Kind.LINE, line = -1)
    )
    public static void online(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
        print(pcn + "." + pmn + ":" + line);
    }
}

