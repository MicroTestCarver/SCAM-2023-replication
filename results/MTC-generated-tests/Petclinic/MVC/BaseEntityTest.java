package org.springframework.samples.petclinic.model;

import org.springframework.samples.petclinic.model.BaseEntity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class BaseEntityTest {

    private BaseEntity subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new BaseEntity();
		subject.setId("1");

    }

    @Test
    public void getIdTest() throws Exception{
		subject.setId("3");


		Integer getId = subject.getId();

		assertThat(getId, is(3));
    }

    @Test
    public void getIdWhereTest() throws Exception{
		Integer getId = subject.getId();

		assertThat(getId, is(1));
    }

    @Test
    public void getIdWhereReturn2Test() throws Exception{
		subject.setId("2");


		Integer getId = subject.getId();

		assertThat(getId, is(2));
    }

}