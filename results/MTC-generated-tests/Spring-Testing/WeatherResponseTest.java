package example.microtestcarver;

import example.weather.WeatherResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class WeatherResponseTest {

    private WeatherResponse subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new WeatherResponse("Clear", "clear sky");

    }

    @Test
    public void getSummaryTest() throws Exception{
		String getSummary = subject.getSummary();

		assertThat(getSummary, is("Clear: clear sky"));
    }

}