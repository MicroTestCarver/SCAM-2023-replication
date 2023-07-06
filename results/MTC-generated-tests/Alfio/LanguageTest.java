package alfio;

import alfio.controller.api.v2.model.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LanguageTest {

    private Language subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new Language("en", "English");
    }

    @Test
    public void shouldTestGetLocale(){
		String getLocale = subject.getLocale();

		assertThat(getLocale, is("en"));
    }

    @Test
    public void shouldTestGetDisplayLanguage(){
		String getDisplayLanguage = subject.getDisplayLanguage();

		assertThat(getDisplayLanguage, is("English"));
    }

}