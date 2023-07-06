import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParserTests {
    @Test
    public void shortTypeTest(){
        String s = "TicketReservation$TicketReservationStatus";
        s = s.replaceAll("\\$", "\\.");

        assertThat(s, is("TicketReservation.TicketReservationStatus"));
    }
}
