package example.microtestcarver;

import example.ExampleController;

import example.person.Person;
import example.person.PersonRepository;
import example.weather.WeatherClient;
import example.weather.WeatherResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class ExampleControllerTest {

    private ExampleController subject;

    @Mock
    private WeatherClient weatherClient;
    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new ExampleController(personRepository, weatherClient);
    }

    @Test
    public void weatherTest() throws Exception{
		given(weatherClient.fetchWeather()).willReturn(Optional.of(new WeatherResponse("Clear", "clear sky")));

		String weather = subject.weather();

		assertThat(weather, is("Clear: clear sky"));
    }

    @Test
    public void helloTest() throws Exception{
		String hello = subject.hello();

		assertThat(hello, is("Hello World!"));
    }

    @Test
    public void helloWherePeterTest() throws Exception{
		given(personRepository.findByLastName("peter")).willReturn(Optional.empty());

		String hello = subject.hello("peter");

		assertThat(hello, is("Who is this 'peter' you're talking about?"));
    }

    @Test
    public void helloWhereCarterTest() throws Exception{
        Person carter = new Person("james", "carter");

		given(personRepository.findByLastName("carter")).willReturn(Optional.of(carter));

		String hello = subject.hello("carter");

		assertThat(hello, is("Hello james carter!"));
    }

    @Test
    public void helloWhereAmirTest() throws Exception{
		given(personRepository.findByLastName("Amir")).willReturn(Optional.empty());

		String hello = subject.hello("Amir");

		assertThat(hello, is("Who is this 'Amir' you're talking about?"));
    }

}