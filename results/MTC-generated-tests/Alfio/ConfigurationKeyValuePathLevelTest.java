package alfio;

import alfio.model.system.ConfigurationKeyValuePathLevel;
import alfio.model.system.ConfigurationKeys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConfigurationKeyValuePathLevelTest {

    private ConfigurationKeyValuePathLevel subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        String BASE_URL = "https://127.0.0.1:8080/admin";
        subject = new ConfigurationKeyValuePathLevel(ConfigurationKeys.BANK_TRANSFER_ENABLED.getValue(), BASE_URL, null);
    }

    @Test
    public void getConfigurationKeyTest(){
        ConfigurationKeys getConfigurationKey = subject.getConfigurationKey();

        assertThat(getConfigurationKey, is(ConfigurationKeys.BANK_TRANSFER_ENABLED));
    }

    @Test
    public void getValueTest(){
		String getValue = subject.getValue();

		assertThat(getValue, is("https://127.0.0.1:8080/admin"));
    }



}