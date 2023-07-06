/*
 * This file was automatically generated by EvoSuite
 * Mon May 15 15:12:54 GMT 2023
 */

package pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import java.math.BigDecimal;
import org.evosuite.runtime.EvoRunnerJUnit5;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.jupiter.api.extension.RegisterExtension;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.NumericQuestionAnswer;

public class NumericQuestionAnswer_ESTest {
  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testCreatesNumericQuestionAnswer()  throws Throwable  {
      BigDecimal bigDecimal0 = BigDecimal.TEN;
      NumericQuestionAnswer numericQuestionAnswer0 = new NumericQuestionAnswer("pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.QuestionAnswer", bigDecimal0);
      assertEquals("pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.QuestionAnswer", numericQuestionAnswer0.getQuestionCode());
  }
}