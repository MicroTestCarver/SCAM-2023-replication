package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.owner.Pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class PetTest {

    private Pet subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new Pet();
		subject.setBirthDate(LocalDate.parse("2002-08-06"));
		Visit visit = new Visit();
		visit.setDescription("rabies shot");
		visit.setId(2);

		subject.addVisit(visit);
		subject.setId("2");
		subject.setName("Basil");
		PetType petType = new PetType();
		petType.setId(2);
		petType.setName("dog");

		subject.setType(petType);

    }

    @Test
    public void getTypeTest() throws Exception{
		PetType getType = subject.getType();

		PetType petType = new PetType();
		petType.setId(2);
		petType.setName("dog");

		assertThat(getType, is(petType));
    }

    @Test
    public void getVisitsTest() throws Exception{
		PersistentSet getVisits = subject.getVisits();

		Visit visit = new Visit();
		visit.setDescription("rabies shot");
		visit.setId(2);
		PersistentSet<Visit> visits = new PersistentSet<>();
		visits.add(visit);

		assertThat(getVisits, is(visits));
    }

    @Test
    public void getBirthDateTest() throws Exception{
		LocalDate getBirthDate = subject.getBirthDate();

		assertThat(getBirthDate, is(LocalDate.parse("2002-08-06")));
    }

}