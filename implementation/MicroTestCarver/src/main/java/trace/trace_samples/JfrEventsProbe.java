package samples;

import org.openjdk.btrace.core.annotations.BTrace;
import org.openjdk.btrace.core.annotations.Event;
import org.openjdk.btrace.core.annotations.OnMethod;
import org.openjdk.btrace.core.jfr.JfrEvent;

import static org.openjdk.btrace.core.BTraceUtils.Jfr.*;

@BTrace
public class JfrEventsProbe {
    @Event(
            name = "CustomEvent",
            label = "Custom Event",
            fields = {
                    @Event.Field(type = Event.FieldType.INT, name = "a"),
                    @Event.Field(type = Event.FieldType.STRING, name = "b")
            }
    )
    private static JfrEvent.Factory customEventFactory;

    @OnMethod(clazz = "/.*/", method = "/.*/")
    public static void onMethod() {
        JfrEvent event = prepareEvent(customEventFactory);
        setEventField(event, "a", 10);
        setEventField(event, "b", "hello");
        commit(event);
    }
}