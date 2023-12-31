/*
 * This file was automatically generated by EvoSuite
 * Mon May 15 14:48:13 GMT 2023
 */

package pl.altkom.asc.lab.micronaut.poc.product.service.v1.questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import pl.altkom.asc.lab.micronaut.poc.product.service.api.v1.questions.NumericQuestionDto;

public class NumericQuestionDto_ESTest {

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testCreatesNumericQuestionDtoTakingNoArguments()  throws Throwable  {
      NumericQuestionDto numericQuestionDto0 = new NumericQuestionDto();
      assertNull(numericQuestionDto0.getCode());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testCreatesNumericQuestionDtoTaking3Arguments()  throws Throwable  {
      NumericQuestionDto numericQuestionDto0 = new NumericQuestionDto("", (-342), "");
      assertEquals((-342), numericQuestionDto0.getIndex());
  }
}
