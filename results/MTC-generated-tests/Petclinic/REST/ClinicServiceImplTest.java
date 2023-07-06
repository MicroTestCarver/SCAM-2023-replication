package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.service.ClinicServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class ClinicServiceImplTest {

    private ClinicServiceImpl subject;

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new ClinicServiceImpl();

    }

    @Test
    public void findAllOwnersTest() throws Exception{
		given(ownerRepository.findAll()).willReturn(getOwners());

		ArrayList findAllOwners = subject.findAllOwners();

		Owner owner_3 = new Owner();
		owner_1.setLastName("Franklin");
		owner_1.setFirstName("George");
		owner_1.setId(1);

		Owner owner_4 = new Owner();
		owner_2.setLastName("Davis");
		owner_2.setFirstName("Betty");
		owner_2.setId(2);

		ArrayList<Owner> owners_1 = new ArrayList<>();
		owners.add(owner);
		owners.add(owner_2);

		assertThat(findAllOwners, is(owners));
    }

	getOwners(){

	}

}