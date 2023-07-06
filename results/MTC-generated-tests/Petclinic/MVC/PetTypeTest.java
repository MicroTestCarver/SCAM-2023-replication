package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.owner.PetType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class PetTypeTest {

    private PetType subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new PetType();

        subject.setName("cat");
        subject.setId(1);
    }

    @Test
    public void getNameTest() throws Exception {
        String getName = subject.getName();

        assertThat(getName, is("cat"));
    }

    @Test
    public void toStringTest() throws Exception {
        String toString = subject.toString();

        assertThat(toString, is("cat"));
    }
}