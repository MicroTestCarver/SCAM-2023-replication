package alfio;

import alfio.manager.system.ConfigurationLevels;
import alfio.model.system.ConfigurationPathLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SystemLevelTest {

    private ConfigurationLevels.SystemLevel subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new ConfigurationLevels.SystemLevel();
    }

    @Test
    public void shouldTestGetPathLevel(){
		ConfigurationPathLevel getPathLevel = subject.getPathLevel();

		assertThat(getPathLevel, is(ConfigurationPathLevel.SYSTEM));
    }

}