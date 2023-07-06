package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.owner.Visit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class VisitTest {

    private Visit subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new Visit();
		subject.setDescription("rabies shot");
		subject.setId("2");
		subject.setDate(LocalDate.parse("2011-03-04"));

    }

    @Test
    public void getDateTest() throws Exception{
		LocalDate getDate = subject.getDate();

		assertThat(getDate, is(LocalDate.parse("2011-03-04")));
    }

    @Test
    public void getDescriptionTest() throws Exception{
		String getDescription = subject.getDescription();

		assertThat(getDescription, is("rabies shot"));
    }

}