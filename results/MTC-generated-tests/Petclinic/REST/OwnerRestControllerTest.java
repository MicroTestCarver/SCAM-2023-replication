package org.springframework.samples.petclinic.rest.controller;

import org.springframework.samples.petclinic.rest.controller.OwnerRestController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class OwnerRestControllerTest {

    private OwnerRestController subject;

    @Mock
    private ClinicService clinicService;
    @Mock
    private OwnerMapper ownerMapper;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new OwnerRestController();

    }

    @Test
    public void listOwnersTest() throws Exception{
		given(clinicService.findAllOwners()).willReturn(null);
        PersistentSet<Visit> visits = new PersistentSet<>();
		Owner owner_1 = new Owner();
		PetType petType = new PetType();
		Pet pet = new Pet();
		pet.setVisits(visits);
		pet.setOwner(owner_1);
		pet.setId(1);
		pet.setType(petType);
		pet.setBirthDate(LocalDate.parse("2010-09-07"));
		pet.setName("Leo");
		PersistentSet<Pet> pets = new PersistentSet<>();
		pets.add(pet);
		Owner owner = new Owner();
		owner.setPets(pets);
		owner.setAddress("110 W. Liberty St.");
		owner.setCity("Madison");
		owner.setLastName("Franklin");
		owner.setFirstName("George");
		owner.setTelephone("6085551023");
		owner.setId(1);
		PersistentSet<Visit> visits_1 = new PersistentSet<>();
		Owner owner_3 = new Owner();
		PetType petType_1 = new PetType();
		Pet pet_1 = new Pet();
		pet_1.setVisits(visits_1);
		pet_1.setOwner(owner_3);
		pet_1.setId(2);
		pet_1.setType(petType_1);
		pet_1.setBirthDate(LocalDate.parse("2012-08-06"));
		pet_1.setName("Basil");
		PersistentSet<Pet> pets_1 = new PersistentSet<>();
		pets_1.add(pet_1);
		Owner owner_2 = new Owner();
		owner_2.setPets(pets_1);
		owner_2.setAddress("638 Cardinal Ave.");
		owner_2.setCity("Sun Prairie");
		owner_2.setLastName("Davis");
		owner_2.setFirstName("Betty");
		owner_2.setTelephone("6085551749");
		owner_2.setId(2);
		PersistentSet<Visit> visits_2 = new PersistentSet<>();
		Owner owner_5 = new Owner();
		PetType petType_2 = new PetType();
		Pet pet_2 = new Pet();
		pet_2.setVisits(visits_2);
		pet_2.setOwner(owner_5);
		pet_2.setId(3);
		pet_2.setType(petType_2);
		pet_2.setBirthDate(LocalDate.parse("2011-04-17"));
		pet_2.setName("Rosy");
		PersistentSet<Pet> pets_2 = new PersistentSet<>();
		pets_2.add(pet_2);
		Owner owner_4 = new Owner();
		owner_4.setPets(pets_2);
		owner_4.setAddress("2693 Commerce St.");
		owner_4.setCity("McFarland");
		owner_4.setLastName("Rodriquez");
		owner_4.setFirstName("Eduardo");
		owner_4.setTelephone("6085558763");
		owner_4.setId(3);
		ArrayList<Owner> owners = new ArrayList<>();
		owners.add(owner);
		owners.add(owner_2);
		owners.add(owner_4);

		given(ownerMapper.toOwnerDtoCollection(owners)).willReturn(null);

		ResponseEntity listOwners = subject.listOwners();

		assertThat(listOwners, is(<200 OK OK,[class OwnerDto {
    firstName: George
    lastName: Franklin
    address: 110 W. Liberty St.
    city: Madison
    telephone: 6085551023
    id: 1
    pets: [class PetDto {
        name: Leo
        birthDate: 2010-09-07
        type: class PetTypeDto {
            name: cat
            id: 1
        }
        id: 1
        ownerId: 1
        visits: [class VisitDto {
            date: 2013-01-01
            description: rabies shot
            id: 1
            petId: null
        }]
    }]
}, class OwnerDto {
    firstName: Betty
    lastName: Davis
    address: 638 Cardinal Ave.
    city: Sun Prairie
    telephone: 6085551749
    id: 2
    pets: [class PetDto {
        name: Basil
        birthDate: 2012-08-06
        type: class PetTypeDto {
            name: dog
            id: 2
        }
        id: 2
        ownerId: 2
        visits: [class VisitDto {
            date: 2013-01-02
            description: rabies shot
            id: 2
            petId: null
        }]
    }]
}, class OwnerDto {
    firstName: Eduardo
    lastName: Rodriquez
    address: 2693 Commerce St.
    city: McFarland
    telephone: 6085558763
    id: 3
    pets: [class PetDto {
        name: Rosy
        birthDate: 2011-04-17
        type: class PetTypeDto {
            name: bird
            id: 3
        }
        id: 3
        ownerId: 3
        visits: [class VisitDto {
            date: 2013-01-03
            description: neutered
            id: 3
            petId: null
        }]
    }]
}],[]>));
    }

}