package alfio;

import alfio.controller.api.admin.LocationApiController;
import alfio.model.system.ConfigurationKeys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProviderAndKeysTest {

    private LocationApiController.ProviderAndKeys subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new LocationApiController.ProviderAndKeys(ConfigurationKeys.GeoInfoProvider.NONE, new HashMap<>());
    }

    @Test
    public void shouldTestGetProvider(){
		ConfigurationKeys.GeoInfoProvider getProvider = subject.getProvider();

		assertThat(getProvider, is(ConfigurationKeys.GeoInfoProvider.NONE));
    }

}