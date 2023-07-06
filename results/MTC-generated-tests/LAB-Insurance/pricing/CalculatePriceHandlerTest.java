package pl.altkom.asc.lab.micronaut.poc.pricing.microtestcarver;

import pl.altkom.asc.lab.micronaut.poc.pricing.commands.CalculatePriceHandler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.altkom.asc.lab.micronaut.poc.pricing.domain.Calculation;
import pl.altkom.asc.lab.micronaut.poc.pricing.domain.Tariff;
import pl.altkom.asc.lab.micronaut.poc.pricing.domain.Tariffs;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.CalculatePriceCommand;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.CalculatePriceResult;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class CalculatePriceHandlerTest {

    private CalculatePriceHandler subject;

    @Mock
    private Tariffs tariffs;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		subject = new CalculatePriceHandler(tariffs);

    }

//    @Test
//    public void toCalculationTest() throws Exception{
//		CalculatePriceCommand calculatePriceCommand = new CalculatePriceCommand();
//
//		Calculation toCalculation = subject.toCalculation(calculatePriceCommand);
//
//		assertThat(toCalculation, is(pl.altkom.asc.lab.micronaut.poc.pricing.domain.Calculation@7f3b84b8));
//    }

//    @Test
//    public void handleTest() throws Exception{
//		given(tariffs.getByCode("FAI")).willReturn(new Tariff());
//
//		CalculatePriceCommand calculatePriceCommand = new CalculatePriceCommand();
//
//		CalculatePriceResult handle = subject.handle(calculatePriceCommand);
//
//		CalculatePriceResult calculatePriceResult = new CalculatePriceResult();
//
//		assertThat(handle, is(calculatePriceResult));
//    }

//    @Test
//    public void resultFromCalculationTest() throws Exception{
//		CalculatePriceResult resultFromCalculation = subject.resultFromCalculation(pl.altkom.asc.lab.micronaut.poc.pricing.domain.Calculation@4e31276e);
//
//		CalculatePriceResult calculatePriceResult = new CalculatePriceResult();
//
//		assertThat(resultFromCalculation, is(calculatePriceResult));
//    }

}