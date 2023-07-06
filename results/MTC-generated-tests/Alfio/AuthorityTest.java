package alfio;

import alfio.model.user.Authority;
import alfio.model.user.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AuthorityTest {

    private Authority subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new Authority("admin", "ROLE_ADMIN");
    }

    @Test
    public void shouldTestGetRole(){
		Role getRole = subject.getRole();

		assertThat(getRole, is(Role.ADMIN));
    }

}