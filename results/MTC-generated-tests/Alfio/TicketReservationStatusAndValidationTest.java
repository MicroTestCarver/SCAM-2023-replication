package alfio;

import alfio.model.TicketReservation;
import alfio.model.TicketReservationStatusAndValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static alfio.model.TicketReservation.TicketReservationStatus.PENDING;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TicketReservationStatusAndValidationTest {

    private TicketReservationStatusAndValidation subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new TicketReservationStatusAndValidation(PENDING, true);


    }

    @Test
    public void shouldTestGetStatus(){
        subject = new TicketReservationStatusAndValidation(PENDING, true);
		TicketReservation.TicketReservationStatus getStatus = subject.getStatus();

		assertThat(getStatus, is(TicketReservation.TicketReservationStatus.PENDING));
    }

}