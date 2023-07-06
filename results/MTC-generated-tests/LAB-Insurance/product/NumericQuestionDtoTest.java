package pl.altkom.asc.lab.micronaut.poc.product.service.microtestcarver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import pl.altkom.asc.lab.micronaut.poc.product.service.api.v1.questions.NumericQuestionDto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumericQuestionDtoTest {

    private NumericQuestionDto subject;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new NumericQuestionDto("NUM_OF_ADULTS", 2, "Number of adults");
    }

    @Test
    public void getTextTest() throws Exception{
        String getText = subject.getText();

        assertThat(getText, is("Number of adults"));
    }

}