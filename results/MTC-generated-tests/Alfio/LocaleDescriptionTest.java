package alfio;

import alfio.model.EventDescription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LocaleDescriptionTest {

    private EventDescription.LocaleDescription subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new EventDescription.LocaleDescription("en", "AST 2022 - Conference");


    }

    @Test
    public void shouldTestGetDescription(){
		String getDescription = subject.getDescription();

		assertThat(getDescription, is("AST 2022 - Conference"));
    }

    @Test
    public void shouldTestGetLocale(){
		String getLocale = subject.getLocale();

		assertThat(getLocale, is("en"));
    }

}