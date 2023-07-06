package pl.altkom.asc.lab.micronaut.poc.pricing.microtestcarver;

import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.CalculatePriceCommand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.QuestionAnswer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class CalculatePriceCommandTest {

    private CalculatePriceCommand subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new CalculatePriceCommand();
		subject.setPolicyFrom(LocalDate.parse("2023-05-17"));
		subject.setPolicyTo(LocalDate.parse("2023-05-31"));
		subject.setProductCode("FAI");

		QuestionAnswer questionAnswer = new QuestionAnswer();
		questionAnswer.setAnswer("KW");
		questionAnswer.setQuestionCode("TYP");
		ArrayList<QuestionAnswer> questionAnswers = new ArrayList<>();
		questionAnswers.add(questionAnswer);

		subject.setAnswers(questionAnswers);

		ArrayList<String> strings = new ArrayList<>();

		strings.add("C1");
		strings.add("C2");
		strings.add("C3");
		strings.add("C4");
		subject.setSelectedCovers(strings);
	}

	@Test
	public void getPolicyToTest() throws Exception{
		LocalDate getPolicyTo = subject.getPolicyTo();

		assertThat(getPolicyTo, is(LocalDate.parse("2023-05-31")));
	}

    @Test
    public void getPolicyFromTest() throws Exception{
		LocalDate getPolicyFrom = subject.getPolicyFrom();

		assertThat(getPolicyFrom, is(LocalDate.parse("2023-05-17")));
    }

    @Test
    public void getProductCodeTest() throws Exception{
		String getProductCode = subject.getProductCode();

		assertThat(getProductCode, is("FAI"));
    }

    @Test
    public void getSelectedCoversTest() throws Exception{
		List getSelectedCovers = subject.getSelectedCovers();

		ArrayList<String> strings = new ArrayList<>();
		strings.add("C1");
		strings.add("C2");
		strings.add("C3");
		strings.add("C4");

		assertThat(getSelectedCovers, is(strings));
    }

    @Test
    public void getAnswersTest() throws Exception{
		List<QuestionAnswer> getAnswers = subject.getAnswers();

		QuestionAnswer questionAnswer = new QuestionAnswer();
		questionAnswer.setAnswer("KW");
		questionAnswer.setQuestionCode("TYP");
		ArrayList<QuestionAnswer> questionAnswers = new ArrayList<>();
		questionAnswers.add(questionAnswer);

		assertThat(getAnswers, is(questionAnswers));
    }

}