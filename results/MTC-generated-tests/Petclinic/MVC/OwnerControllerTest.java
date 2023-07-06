package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.owner.OwnerController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class OwnerControllerTest {

    private OwnerController subject;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new OwnerController();

    }

    @Test
    public void findOwnerTest() throws Exception{
		Owner findOwner = subject.findOwner();

		Owner owner = new Owner();

		assertThat(findOwner, is(owner));
    }

    @Test
    public void findOwnerWhereTest() throws Exception{
		Owner findOwner = subject.findOwner();

		Owner owner = new Owner();
		owner.setLastName("");

		assertThat(findOwner, is(owner));
    }

    @Test
    public void findOwnerTest() throws Exception{
		given(owners.findById(2)).willReturn(getOwner());

		Owner findOwner = subject.findOwner(2);

		PetType petType = new PetType();
		petType.setName("dog");
		Pet pet = new Pet();
		pet.setType(petType);
		pet.setBirthDate(LocalDate.parse("2002-08-06"));
		pet.setName("Basil");

		Owner owner = new Owner();
		owner.addPet(pet);
		owner.setAddress("638 Cardinal Ave.");
		owner.setCity("Sun Prairie");
		owner.setLastName("Davis");
		owner.setFirstName("Betty");
		owner.setTelephone("6085551749");
		owner.setId(2);

		assertThat(findOwner, is(owner));
    }

    @Test
    public void showOwnerTest() throws Exception{
		given(owners.findById(2)).willReturn(null);

		ModelAndView showOwner = subject.showOwner(2);

		assertThat(showOwner, is(ModelAndView [view="owners/ownerDetails"; model={owner=[Owner@2cae1042 id = 2, new = false, lastName = 'Davis', firstName = 'Betty', address = '638 Cardinal Ave.', city = 'Sun Prairie', telephone = '6085551749']}]));
    }

    @Test
    public void processFindFormTest() throws Exception{
		Owner owner = new Owner();
		owner.setLastName("");
		BindingAwareModelMap<String, Owner> stringMappedOwner = new BindingAwareModelMap<>();
		stringMappedOwner.put("owner", owner);
		stringMappedOwner.put("org.springframework.validation.BindingResult.owner", org.springframework.validation.BeanPropertyBindingResult: 0 errors);

		Owner owner_1 = new Owner();
		owner_1.setLastName("");

		String processFindForm = subject.processFindForm(stringMappedOwner, owner_1, org.springframework.validation.BeanPropertyBindingResult: 0 errors, 1);

		assertThat(processFindForm, is("owners/ownersList"));
    }

    @Test
    public void findPaginatedForOwnersLastNameTest() throws Exception{
		given(owners.findByLastName(Page request [number: 0, size 5, sort: UNSORTED], "")).willReturn(null);

		PageImpl findPaginatedForOwnersLastName = subject.findPaginatedForOwnersLastName("", 1);

		assertThat(findPaginatedForOwnersLastName, is(Page 1 of 1 containing org.springframework.samples.petclinic.owner.Owner instances));
    }

    @Test
    public void initFindFormTest() throws Exception{
		Owner owner = new Owner();
		BindingAwareModelMap<String, Owner> stringMappedOwner = new BindingAwareModelMap<>();
		stringMappedOwner.put("owner", owner);

		String initFindForm = subject.initFindForm(stringMappedOwner);

		assertThat(initFindForm, is("owners/findOwners"));
    }

    @Test
    public void addPaginationModelTest() throws Exception{
		Owner owner = new Owner();
		owner.setLastName("");
		BindingAwareModelMap<String, Owner> stringMappedOwner = new BindingAwareModelMap<>();
		stringMappedOwner.put("owner", owner);
		stringMappedOwner.put("org.springframework.validation.BindingResult.owner", org.springframework.validation.BeanPropertyBindingResult: 0 errors);

		String addPaginationModel = subject.addPaginationModel(stringMappedOwner, Page 1 of 1 containing org.springframework.samples.petclinic.owner.Owner instances, 1);

		assertThat(addPaginationModel, is("owners/ownersList"));
    }

}