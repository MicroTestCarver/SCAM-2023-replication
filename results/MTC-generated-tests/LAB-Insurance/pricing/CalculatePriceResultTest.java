package pl.altkom.asc.lab.micronaut.poc.pricing.microtestcarver;

import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.CalculatePriceResult;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class CalculatePriceResultTest {

    private CalculatePriceResult subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		HashMap<String, BigDecimal> stringMappedBigDecimal = new HashMap<>();
		stringMappedBigDecimal.put("C3", new BigDecimal("90.00"));
		stringMappedBigDecimal.put("C4", new BigDecimal("120.00"));
		stringMappedBigDecimal.put("C1", new BigDecimal("30.00"));
		stringMappedBigDecimal.put("C2", new BigDecimal("60.00"));

		subject = new CalculatePriceResult(new BigDecimal("300.00"), stringMappedBigDecimal);

    }

    @Test
    public void getTotalPriceTest() throws Exception{
		subject.setTotalPrice(new BigDecimal("300.00"));
		BigDecimal getTotalPrice = subject.getTotalPrice();

		assertThat(getTotalPrice, is(new BigDecimal("300.00")));
    }

    @Test
    public void getCoversPricesTest() throws Exception{
		Map getCoversPrices = subject.getCoversPrices();

		HashMap<String, BigDecimal> stringMappedBigDecimal = new HashMap<>();
		stringMappedBigDecimal.put("C3", new BigDecimal("90.00"));
		stringMappedBigDecimal.put("C4", new BigDecimal("120.00"));
		stringMappedBigDecimal.put("C1", new BigDecimal("30.00"));
		stringMappedBigDecimal.put("C2", new BigDecimal("60.00"));

		assertThat(getCoversPrices, is(stringMappedBigDecimal));
    }

}