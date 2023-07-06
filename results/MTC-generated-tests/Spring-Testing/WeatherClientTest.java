package example.microtestcarver;

import example.weather.WeatherClient;

import example.weather.WeatherResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class WeatherClientTest {

    private WeatherClient subject;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new WeatherClient(restTemplate, "https://api.openweathermap.org", "1254aa0ef471380373193a60dd589e35");
    }

    @Test
    public void fetchWeatherTest() throws Exception{
        given(restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=Hamburg,de&appid=1254aa0ef471380373193a60dd589e35",
                WeatherResponse.class)).willReturn(new WeatherResponse("Clear", "clear sky"));

		Optional fetchWeather = subject.fetchWeather();

		assertThat(fetchWeather, is(Optional.of(new WeatherResponse("Clear", "clear sky"))));
    }

}