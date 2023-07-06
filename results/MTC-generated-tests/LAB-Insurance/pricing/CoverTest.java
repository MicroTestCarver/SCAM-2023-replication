package pl.altkom.asc.lab.micronaut.poc.pricing.microtestcarver;

import pl.altkom.asc.lab.micronaut.poc.pricing.domain.Cover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
		subject = new Cover("C1", new BigDecimal("30"));

    }

    @Test
    public void getCodeTest() throws Exception{
		String getCode = subject.getCode();

		assertThat(getCode, is("C1"));
    }

    @Test
    public void getPriceTest() throws Exception{
		BigDecimal getPrice = subject.getPrice();

		assertThat(getPrice, is(new BigDecimal("30")));
    }

}