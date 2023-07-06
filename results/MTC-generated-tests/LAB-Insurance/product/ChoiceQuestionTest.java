package pl.altkom.asc.lab.micronaut.poc.product.service.microtestcarver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import pl.altkom.asc.lab.micronaut.poc.product.service.domain.Choice;
import pl.altkom.asc.lab.micronaut.poc.product.service.domain.ChoiceQuestion;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChoiceQuestionTest {

    private ChoiceQuestion subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		ArrayList<Choice> choices = new ArrayList<>();
		choices.add(new Choice("ZB", "Crop"));
		choices.add(new Choice("KW", "Vegetable"));

		subject = new ChoiceQuestion("FLOOD", 4, "Destination", choices);

    }

    @Test
    public void getChoicesTest() throws Exception{
		List<Choice> getChoices = subject.getChoices();

		ArrayList<Choice> choices = new ArrayList<>();
		choices.add(new Choice("ZB", "Crop"));
		choices.add(new Choice("KW", "Vegetable"));

		assertThat(getChoices, is(choices));
    }

}