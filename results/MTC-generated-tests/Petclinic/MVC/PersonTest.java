package org.springframework.samples.petclinic.microtestcarver;

import org.springframework.samples.petclinic.model.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class PersonTest {

    private Person subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new Person();

		subject.setId(1);
		subject.setFirstName("George");
		subject.setLastName("Franklin");

    }

    @Test
    public void GetFirstName(){
		String getFirstName = subject.getFirstName();

		assertThat(getFirstName, is("George"));
    }

	@Test
	public void GetLastName(){
		String getLastName = subject.getLastName();

		assertThat(getLastName, is("Franklin"));
	}

}
