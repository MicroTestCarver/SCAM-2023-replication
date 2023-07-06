package org.springframework.samples.petclinic.microtestcarver;

import org.springframework.samples.petclinic.model.NamedEntity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class NamedEntityTest {

    private NamedEntity subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new NamedEntity();

		subject.setId(1);
		subject.setName("Basil");

    }

    @Test
    public void toStringTest() throws Exception {
		subject.setName("Leo");

		String toString = subject.toString();

		assertThat(toString, is("Leo"));
    }

    @Test
    public void getNameTest() throws Exception {
		subject.setName("Leo");

		String getName = subject.getName();

		assertThat(getName, is("Leo"));
    }

}
