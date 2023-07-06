/*
 * This file was automatically generated by EvoSuite
 * Mon May 15 14:39:34 GMT 2023
 */

package pl.altkom.asc.lab.micronaut.poc.product.service.v1.questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import pl.altkom.asc.lab.micronaut.poc.product.service.api.v1.questions.QuestionDto;

public class QuestionDto_ESTest {

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetTextReturningNonEmptyString()  throws Throwable  {
      QuestionDto questionDto0 = new QuestionDto("", 1, "|*KeCT` %R");
      String string0 = questionDto0.getText();
      assertEquals("|*KeCT` %R", string0);
      assertEquals(1, questionDto0.getIndex());
      assertEquals("", questionDto0.getCode());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetTextReturningEmptyString()  throws Throwable  {
      QuestionDto questionDto0 = new QuestionDto("", 4, "");
      questionDto0.getText();
      assertEquals(4, questionDto0.getIndex());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetIndexReturningZero()  throws Throwable  {
      QuestionDto questionDto0 = new QuestionDto();
      int int0 = questionDto0.getIndex();
      assertEquals(0, int0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetIndexReturningPositive()  throws Throwable  {
      QuestionDto questionDto0 = new QuestionDto("", 4, "");
      int int0 = questionDto0.getIndex();
      assertEquals(4, int0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetCodeReturningNonEmptyString()  throws Throwable  {
      QuestionDto questionDto0 = new QuestionDto("kg]gyZ`pSLSQ]<", 2243, "@class");
      String string0 = questionDto0.getCode();
      assertEquals("kg]gyZ`pSLSQ]<", string0);
      assertEquals("@class", questionDto0.getText());
      assertEquals(2243, questionDto0.getIndex());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetCodeReturningEmptyString()  throws Throwable  {
      QuestionDto questionDto0 = new QuestionDto("", 4, "");
      questionDto0.getCode();
      assertEquals(4, questionDto0.getIndex());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetCodeReturningNull()  throws Throwable  {
      QuestionDto questionDto0 = new QuestionDto();
      String string0 = questionDto0.getCode();
      assertNull(string0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetTextReturningNull()  throws Throwable  {
      QuestionDto questionDto0 = new QuestionDto();
      String string0 = questionDto0.getText();
      assertNull(string0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetIndexReturningNegative()  throws Throwable  {
      QuestionDto questionDto0 = new QuestionDto("", (-555), "Nv=cv#5xc:.h'M'");
      int int0 = questionDto0.getIndex();
      assertEquals("", questionDto0.getCode());
      assertEquals("Nv=cv#5xc:.h'M'", questionDto0.getText());
      assertEquals((-555), int0);
  }
}
