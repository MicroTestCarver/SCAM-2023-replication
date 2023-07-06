package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.owner.Owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class OwnerTest {

    private Owner subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new Owner();
		Visit visit = new Visit();
		visit.setDescription("rabies shot");
		visit.setId(2);
		PetType petType = new PetType();
		petType.setId(2);
		petType.setName("dog");
		Pet pet = new Pet();
		pet.addVisit(visit);
		pet.setId(2);
		pet.setType(petType);
		pet.setBirthDate(LocalDate.parse("2002-08-06"));
		pet.setName("Basil");

		subject.addPet(pet);
		subject.setLastName("Davis");
		subject.setCity("Madison");
		subject.setId("1");
		subject.setAddress("110 W. Liberty St.");
		subject.setTelephone("6085551023");
		subject.setFirstName("Betty");

    }

    @Test
    public void getPetsTest() throws Exception
		PersistentBag getPets = subject.getPets();

		PetType petType = new PetType();
		petType.setId(1);
		petType.setName("cat");
		Pet pet = new Pet();
		pet.addVisit(visit_1);
		pet.setId(1);
		pet.setType(petType_1);
		pet.setBirthDate(LocalDate.parse("2000-09-07"));
		pet.setName("Leo");
		PersistentBag<Pet> pets = new PersistentBag<>();
		pets.add(pet);

		assertThat(getPets, is(pets));
    }

    @Test
    public void getPetsWhereTest() throws Exception{
		subject.setCity("Sun Prairie");
		subject.setId("2");
		subject.setAddress("638 Cardinal Ave.");
		subject.setTelephone("6085551749");


		PersistentBag getPets = subject.getPets();

		Visit visit = new Visit();
		visit.setDescription("rabies shot");
		visit.setId(2);
		PetType petType = new PetType();
		petType.setId(2);
		petType.setName("dog");
		Pet pet = new Pet();
		pet.addVisit(visit);
		pet.setId(2);
		pet.setType(petType);
		pet.setBirthDate(LocalDate.parse("2002-08-06"));
		pet.setName("Basil");
		PersistentBag<Pet> pets = new PersistentBag<>();
		pets.add(pet);

		assertThat(getPets, is(pets));
    }

    @Test
    public void getPetsWhereReturn[Rosy]Test() throws Exception{
		subject.setFirstName("Eduardo");
		subject.setAddress("2693 Commerce St.");
		Visit visit = new Visit();
		visit.setDescription("neutered");
		visit.setId(3);
		PetType petType = new PetType();
		petType.setId(3);
		petType.setName("bird");
		Pet pet = new Pet();
		pet.addVisit(visit);
		pet.setId(3);
		pet.setType(petType);
		pet.setBirthDate(LocalDate.parse("2001-04-17"));
		pet.setName("Rosy");

		subject.addPet(pet);
		subject.setCity("McFarland");
		subject.setId("3");
		subject.setTelephone("6085558763");
		subject.setLastName("Rodriquez");


		PersistentBag getPets = subject.getPets();

		Visit visit_1 = new Visit();
		visit_1.setDescription("neutered");
		visit_1.setId(3);
		PetType petType_1 = new PetType();
		petType_1.setId(3);
		petType_1.setName("bird");
		Pet pet_1 = new Pet();
		pet_1.addVisit(visit_1);
		pet_1.setId(3);
		pet_1.setType(petType_1);
		pet_1.setBirthDate(LocalDate.parse("2001-04-17"));
		pet_1.setName("Rosy");
		PersistentBag<Pet> pets = new PersistentBag<>();
		pets.add(pet_1);

		assertThat(getPets, is(pets));
    }

    @Test
    public void getTelephoneTest() throws Exception{
		subject.setFirstName("George");
		subject.setLastName("Franklin");
		Visit visit = new Visit();
		visit.setDescription("rabies shot");
		visit.setId(1);
		PetType petType = new PetType();
		petType.setId(1);
		petType.setName("cat");
		Pet pet = new Pet();
		pet.addVisit(visit);
		pet.setId(1);
		pet.setType(petType);
		pet.setBirthDate(LocalDate.parse("2000-09-07"));
		pet.setName("Leo");

		subject.addPet(pet);


		String getTelephone = subject.getTelephone();

		assertThat(getTelephone, is("6085551023"));
    }

    @Test
    public void getTelephoneWhereTest() throws Exception{
		subject.setCity("Sun Prairie");
		subject.setId("2");
		subject.setAddress("638 Cardinal Ave.");
		subject.setTelephone("6085551749");


		String getTelephone = subject.getTelephone();

		assertThat(getTelephone, is("6085551749"));
    }

    @Test
    public void getTelephoneWhereReturnStringTest() throws Exception{
		subject.setFirstName("Eduardo");
		subject.setAddress("2693 Commerce St.");
		Visit visit = new Visit();
		visit.setDescription("neutered");
		visit.setId(3);
		PetType petType = new PetType();
		petType.setId(3);
		petType.setName("bird");
		Pet pet = new Pet();
		pet.addVisit(visit);
		pet.setId(3);
		pet.setType(petType);
		pet.setBirthDate(LocalDate.parse("2001-04-17"));
		pet.setName("Rosy");

		subject.addPet(pet);
		subject.setCity("McFarland");
		subject.setId("3");
		subject.setTelephone("6085558763");
		subject.setLastName("Rodriquez");


		String getTelephone = subject.getTelephone();

		assertThat(getTelephone, is("6085558763"));
    }

    @Test
    public void getAddressTest() throws Exception{
		subject.setFirstName("George");
		subject.setLastName("Franklin");
		Visit visit = new Visit();


		String getAddress = subject.getAddress();

		assertThat(getAddress, is("110 W. Liberty St."));
    }

    @Test
    public void getAddressWhereTest() throws Exception{
		subject.setCity("Sun Prairie");
		subject.setId("2");
		subject.setAddress("638 Cardinal Ave.");
		subject.setTelephone("6085551749");


		String getAddress = subject.getAddress();

		assertThat(getAddress, is("638 Cardinal Ave."));
    }

    @Test
    public void getAddressWhereReturnStringTest() throws Exception{
		subject.setFirstName("Eduardo");
		subject.setAddress("2693 Commerce St.");
		Visit visit = new Visit();
		visit.setDescription("neutered");
		visit.setId(3);
		PetType petType = new PetType();
		petType.setId(3);
		petType.setName("bird");
		Pet pet = new Pet();
		pet.addVisit(visit);
		pet.setId(3);
		pet.setType(petType);
		pet.setBirthDate(LocalDate.parse("2001-04-17"));
		pet.setName("Rosy");

		subject.addPet(pet);
		subject.setCity("McFarland");
		subject.setId("3");
		subject.setTelephone("6085558763");
		subject.setLastName("Rodriquez");


		String getAddress = subject.getAddress();

		assertThat(getAddress, is("2693 Commerce St."));
    }

    @Test
    public void getCityTest() throws Exception{
		subject.setFirstName("George");
		subject.setLastName("Franklin");
		Visit visit = new Visit();
		visit.setDescription("rabies shot");
		visit.setId(1);
		PetType petType = new PetType();
		petType.setId(1);
		petType.setName("cat");
		Pet pet = new Pet();
		pet.addVisit(visit);
		pet.setId(1);
		pet.setType(petType);
		pet.setBirthDate(LocalDate.parse("2000-09-07"));
		pet.setName("Leo");

		subject.addPet(pet);


		String getCity = subject.getCity();

		assertThat(getCity, is("Madison"));
    }

    @Test
    public void getCityWhereTest() throws Exception{
		subject.setCity("Sun Prairie");
		subject.setId("2");
		subject.setAddress("638 Cardinal Ave.");
		subject.setTelephone("6085551749");


		String getCity = subject.getCity();

		assertThat(getCity, is("Sun Prairie"));
    }

    @Test
    public void getCityWhereReturnMcFarlandTest() throws Exception{
		subject.setFirstName("Eduardo");
		subject.setAddress("2693 Commerce St.");
		Visit visit = new Visit();
		visit.setDescription("neutered");
		visit.setId(3);
		PetType petType = new PetType();
		petType.setId(3);
		petType.setName("bird");
		Pet pet = new Pet();
		pet.addVisit(visit);
		pet.setId(3);
		pet.setType(petType);
		pet.setBirthDate(LocalDate.parse("2001-04-17"));
		pet.setName("Rosy");

		subject.addPet(pet);
		subject.setCity("McFarland");
		subject.setId("3");
		subject.setTelephone("6085558763");
		subject.setLastName("Rodriquez");


		String getCity = subject.getCity();

		assertThat(getCity, is("McFarland"));
    }

}