package alfio;

import alfio.util.CustomResourceBundleMessageSource;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class CustomResourceBundleMessageSourceTest {

    private CustomResourceBundleMessageSource subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new CustomResourceBundleMessageSource();
    }

}