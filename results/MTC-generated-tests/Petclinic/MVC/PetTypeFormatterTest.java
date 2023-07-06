package org.springframework.samples.petclinic.microtestcarver;

import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.samples.petclinic.owner.PetTypeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class PetTypeFormatterTest {

    private PetTypeFormatter subject;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new PetTypeFormatter(owners);
    }

	@Test
	public void printTest() throws Exception{
		PetType petType = new PetType();
		petType.setId(2);
		petType.setName("dog");

		String print = subject.print(petType, Locale.ENGLISH);

		assertThat(print, is("dog"));
	}

	@Test
	public void printWhereCatTest() throws Exception {
		PetType petType = new PetType();
		petType.setId(2);
		petType.setName("cat");

		String print = subject.print(petType, Locale.ENGLISH);

		assertThat(print, is("cat"));
	}

    @Test
    public void parseWhereBirdTest() throws Exception {
		PetType PetType = new PetType();
		PetType.setId(5);
		PetType.setName("bird");
		ArrayList<PetType> petTypes = new ArrayList<>();
		petTypes.add(PetType);

		given(owners.findPetTypes()).willReturn(petTypes);

		PetType parse = subject.parse("bird", Locale.ENGLISH);

		PetType PetType_1 = new PetType();
		PetType_1.setId(5);
		PetType_1.setName("bird");

		assertThat(parse, is(PetType));
    }

    @Test
    public void parseWhereCatTest() throws Exception {
		PetType petType = new PetType();
		petType.setId(1);
		petType.setName("cat");
		PetType petType_1 = new PetType();
		petType_1.setId(2);
		petType_1.setName("dog");
		ArrayList<PetType> petTypes = new ArrayList<>();
		petTypes.add(petType);
		petTypes.add(petType_1);

		given(owners.findPetTypes()).willReturn(petTypes);

		PetType parse = subject.parse("cat", Locale.ENGLISH);

		PetType petType_2 = new PetType();
		petType_2.setId(1);
		petType_2.setName("cat");

		assertThat(parse, is(petType_2));
    }

    @Test
    public void parseWhereDogTest() throws Exception {
		PetType PetType = new PetType();
		PetType.setId(1);
		PetType.setName("cat");
		PetType PetType_1 = new PetType();
		PetType_1.setId(2);
		PetType_1.setName("dog");
		ArrayList<PetType> PetTypes = new ArrayList<>();
		PetTypes.add(PetType);
		PetTypes.add(PetType_1);

		given(owners.findPetTypes()).willReturn(PetTypes);

		PetType parse = subject.parse("dog", Locale.ENGLISH);

		PetType PetType_2 = new PetType();
		PetType_2.setId(2);
		PetType_2.setName("dog");

		assertThat(parse, is(PetType_2));
    }

    @Test
    public void ParseWhereSnakeAndEn_US() throws Exception {
		PetType PetType = new PetType();
		PetType.setId(1);
		PetType.setName("cat");
		PetType PetType_1 = new PetType();
		PetType_1.setId(2);
		PetType_1.setName("dog");
		PetType PetType_2 = new PetType();
		PetType_2.setId(2);
		PetType_2.setName("snake");
		ArrayList<PetType> PetTypes = new ArrayList<>();
		PetTypes.add(PetType);
		PetTypes.add(PetType_1);
		PetTypes.add(PetType_2);

		given(owners.findPetTypes()).willReturn(PetTypes);

		PetType parse = subject.parse("snake", Locale.ENGLISH);

		PetType PetType_3 = new PetType();
		PetType_3.setId(4);
		PetType_3.setName("snake");

		assertThat(parse, is(PetType_3));
    }


    @Test
    public void ParseWhereHamster() throws Exception {
		PetType PetType = new PetType();
		PetType.setId(1);
		PetType.setName("cat");
		PetType PetType_1 = new PetType();
		PetType_1.setId(2);
		PetType_1.setName("dog");
		PetType PetType_2 = new PetType();
		PetType_2.setId(6);
		PetType_2.setName("hamster");
		ArrayList<PetType> PetTypes = new ArrayList<>();
		PetTypes.add(PetType);
		PetTypes.add(PetType_1);
		PetTypes.add(PetType_2);

		given(owners.findPetTypes()).willReturn(PetTypes);

		PetType parse = subject.parse("hamster", Locale.ENGLISH);

		PetType PetType_3 = new PetType();
		PetType_3.setId(6);
		PetType_3.setName("hamster");

		assertThat(parse, is(PetType_3));
    }

    @Test
    public void ParseWhereLizard() throws Exception {
		PetType petType = new PetType();
		petType.setId(1);
		petType.setName("cat");
		PetType petType_1 = new PetType();
		petType_1.setId(2);
		petType_1.setName("dog");
		PetType petType_2 = new PetType();
		petType_2.setId(3);
		petType_2.setName("lizard");
		ArrayList<PetType> petTypes = new ArrayList<>();
		petTypes.add(petType);
		petTypes.add(petType_1);
		petTypes.add(petType_2);

		given(owners.findPetTypes()).willReturn(petTypes);

		PetType parse = subject.parse("lizard", Locale.ENGLISH);

		PetType petType_3 = new PetType();
		petType_3.setId(3);
		petType_3.setName("lizard");

		assertThat(parse, is(petType_3));
    }

}
