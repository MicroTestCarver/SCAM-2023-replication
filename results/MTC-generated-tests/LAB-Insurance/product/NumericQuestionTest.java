package pl.altkom.asc.lab.micronaut.poc.product.service.microtestcarver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import pl.altkom.asc.lab.micronaut.poc.product.service.domain.NumericQuestion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumericQuestionTest {

    private NumericQuestion subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new NumericQuestion("NUM_OF_CLAIM", 2, "Number of claims in last 5 years");

    }


    @Test
    public void getTextTest() throws Exception{
        String getText = subject.getText();

        assertThat(getText, is("Number of claims in last 5 years"));
    }

    @Test
    public void getCode() throws Exception{
        String getCode = subject.getCode();

        assertThat(getCode, is("NUM_OF_CLAIM"));
    }

    @Test
    public void getIndex() throws Exception{
        int getIndex = subject.getIndex();

        assertThat(getIndex, is(2));
    }

}