package alfio;

import alfio.model.user.Organization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OrganizationContactTest {

    private Organization.OrganizationContact subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new Organization.OrganizationContact("ACM", "info@acm.org");


    }

    @Test
    public void shouldTestGetEmail(){
        subject = new Organization.OrganizationContact("ACM", "info@acm.org");

        String getEmail = subject.getEmail();

		assertThat(getEmail, is("info@acm.org"));
    }

    @Test
    public void shouldTestGetName(){
		String getName = subject.getName();

		assertThat(getName, is("ACM"));
    }

}