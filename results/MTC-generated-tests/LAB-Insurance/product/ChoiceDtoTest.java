package pl.altkom.asc.lab.micronaut.poc.product.service.microtestcarver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import pl.altkom.asc.lab.micronaut.poc.product.service.api.v1.questions.ChoiceDto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChoiceDtoTest {

    private ChoiceDto subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new ChoiceDto("ZB", "Crop");

    }

    @Test
    public void getCodeTest() throws Exception{
		String getCode = subject.getCode();

		assertThat(getCode, is("ZB"));
    }

    @Test
    public void getLabelTest() throws Exception{
		String getLabel = subject.getLabel();

		assertThat(getLabel, is("Crop"));
    }

}