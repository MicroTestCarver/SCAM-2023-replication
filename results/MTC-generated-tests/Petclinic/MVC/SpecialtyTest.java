package org.springframework.samples.petclinic.microtestcarver;

import org.springframework.samples.petclinic.vet.Specialty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class SpecialtyTest {

    private Specialty subject;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new Specialty();
		subject.setId(5);
    }

	@Test
	public void toStringTest() throws Exception {
		subject.setName("radiology");

		String toString = subject.toString();

		assertThat(toString, is("radiology"));
	}

	@Test
	public void getNameTest() throws Exception {
		subject.setName("radiology");

		String getName = subject.getName();

		assertThat(getName, is("radiology"));
	}

}
