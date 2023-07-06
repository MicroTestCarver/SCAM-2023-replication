package org.springframework.samples.petclinic.system;

import org.springframework.samples.petclinic.system.WelcomeController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class WelcomeControllerTest {

    private WelcomeController subject;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new WelcomeController();

    }

    @Test
    public void welcomeTest() throws Exception{
		given(owners.findAll(Page request [number: 0, size 5, sort: UNSORTED])).willReturn(null);

		String welcome = subject.welcome(new BindingAwareModelMap<>());

		assertThat(welcome, is("welcome"));
    }

}