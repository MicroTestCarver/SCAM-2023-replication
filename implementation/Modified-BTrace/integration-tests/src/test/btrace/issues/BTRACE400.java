package traces.issues;

import static org.openjdk.btrace.core.BTraceUtils.*;

import org.openjdk.btrace.core.annotations.BTrace;
import org.openjdk.btrace.core.annotations.Kind;
import org.openjdk.btrace.core.annotations.Location;
import org.openjdk.btrace.core.annotations.OnMethod;
import org.openjdk.btrace.core.annotations.Self;

/** @author Jaroslav Bachorik */
@BTrace
public class BTRACE400 {
  @OnMethod(clazz = "/.*\\.Main/", method = "callA", location = @Location(value = Kind.RETURN))
  public static void tracker(@Self Object x) {
    println(str(field("resources.Main", "id")));
    println(str(probeClass()));
  }
}
