package pl.altkom.asc.lab.micronaut.poc.pricing.microtestcarver;

import pl.altkom.asc.lab.micronaut.poc.pricing.domain.Calculation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.altkom.asc.lab.micronaut.poc.pricing.domain.Cover;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

public class CalculationTest {

    private Calculation subject;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

		HashMap<String, Object> stringMappedInteger = new HashMap<>();
//		stringMappedInteger.put("NUM_OF_CLAIM", 5);
//		stringMappedInteger.put("FLOOD", 1);
//		stringMappedInteger.put("AREA", 5000);
//		stringMappedInteger.put("TYP", 0);

		ArrayList<String> strings = new ArrayList<>();
		strings.add("C1");
		strings.add("C2");
		strings.add("C3");
		strings.add("C4");

		subject = new Calculation("FAI", LocalDate.parse("2023-05-19"), LocalDate.parse("2023-05-31"), strings, stringMappedInteger);
    }

    @Test
    public void getTotalPremiumTest() throws Exception{
		BigDecimal getTotalPremium = subject.getTotalPremium();

		assertThat(getTotalPremium, is(new BigDecimal(0)));
    }

    @Test
    public void getCoversTest() throws Exception{
		Map getCovers = subject.getCovers();

		Cover cover = new Cover("C1", new BigDecimal(0));
		Cover cover_1 = new Cover("C2",  new BigDecimal(0));
		Cover cover_2 = new Cover("C3",  new BigDecimal(0));
		Cover cover_3 = new Cover("C4",  new BigDecimal(0));
		HashMap<String, Cover> stringMappedCover = new HashMap<>();
		stringMappedCover.put("C1", cover);
		stringMappedCover.put("C2", cover_1);
		stringMappedCover.put("C3", cover_2);
		stringMappedCover.put("C4", cover_3);

		assertThat(getCovers, is(stringMappedCover));
    }

    @Test
    public void toMapTest() throws Exception{
		Map toMap = subject.toMap();

		Cover cover = new Cover("C1", new BigDecimal(0));
		Cover cover_1 = new Cover("C2",  new BigDecimal(0));
		Cover cover_2 = new Cover("C3",  new BigDecimal(0));
		Cover cover_3 = new Cover("C4",  new BigDecimal(0));
		HashMap<String, Object> stringMappedCover = new HashMap<>();
		stringMappedCover.put("policyFrom", LocalDate.parse("2023-05-19"));
		stringMappedCover.put("policyTo", LocalDate.parse("2023-05-31"));
		stringMappedCover.put("C1", cover);
		stringMappedCover.put("C2", cover_1);
		stringMappedCover.put("C3", cover_2);
		stringMappedCover.put("C4", cover_3);

		assertThat(toMap, is(stringMappedCover));
    }

	@Test
	public void getPolicyToTest() throws Exception{
		LocalDate getPolicyTo = subject.getPolicyTo();

		assertThat(getPolicyTo, is(LocalDate.parse("2023-05-31")));
	}

	@Test
	public void getPolicyFromTest() throws Exception{
		LocalDate getPolicyFrom = subject.getPolicyFrom();

		assertThat(getPolicyFrom, is(LocalDate.parse("2023-05-19")));
	}

	@Test
	public void getProductCodeTest() throws Exception{
		String getProductCode = subject.getProductCode();

		assertThat(getProductCode, is("FAI"));
	}

}