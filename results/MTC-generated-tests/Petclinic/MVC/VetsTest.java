package org.springframework.samples.petclinic.microtestcarver;

import org.springframework.samples.petclinic.vet.Vets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class VetsTest {

    private Vets subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new Vets();
    }

    @Test
    public void getVetListTest() throws Exception {
		ArrayList getVetList = (ArrayList) subject.getVetList();

		assertThat(getVetList, is(new ArrayList<>()));
    }

}
