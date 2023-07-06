package pl.altkom.asc.lab.micronaut.poc.product.service.microtestcarver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.altkom.asc.lab.micronaut.poc.product.service.domain.Cover;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class CoverTest {

    private Cover subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new Cover("C1", "Code", "First Cover", false, new BigDecimal("30"));

    }

    @Test
    public void getCodeTest() throws Exception{
		String getCode = subject.getCode();

		assertThat(getCode, is("C1"));
    }

    @Test
    public void getPrice() throws Exception{
		BigDecimal getPrice = subject.getSumInsured();

		assertThat(getPrice, is(new BigDecimal("30")));
    }

}