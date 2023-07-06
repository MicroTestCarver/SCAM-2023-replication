package alfio;

import alfio.model.EventDescription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static alfio.model.EventDescription.EventDescriptionType.DESCRIPTION;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EventDescriptionTest {

    private EventDescription subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new EventDescription(2, "en", DESCRIPTION, "AST 2023 - Conference");
    }

    @Test
    public void getDescriptionTest(){
        subject = new EventDescription(2, "en", DESCRIPTION, "AST 2023 - Conference");

		String getDescription = subject.getDescription();

		assertThat(getDescription, is("AST 2023 - Conference"));
    }

    @Test
    public void shouldTestGetLocale(){
		String getLocale = subject.getLocale();

		assertThat(getLocale, is("en"));
    }

}