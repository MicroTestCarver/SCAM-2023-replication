package pl.altkom.asc.lab.micronaut.poc.product.service.microtestcarver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import pl.altkom.asc.lab.micronaut.poc.product.service.domain.Choice;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChoiceTest {

    private Choice subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new Choice("ZB", "Crop");

    }

    @Test
    public void getLabelTest() throws Exception{
		String getLabel = subject.getLabel();

		assertThat(getLabel, is("Crop"));
    }

    @Test
    public void getCodeTest() throws Exception{
		String getCode = subject.getCode();

		assertThat(getCode, is("ZB"));
    }

}