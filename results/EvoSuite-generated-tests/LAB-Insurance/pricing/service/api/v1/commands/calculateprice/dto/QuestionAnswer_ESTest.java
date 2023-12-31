/*
 * This file was automatically generated by EvoSuite
 * Mon May 15 15:29:03 GMT 2023
 */

package pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import org.evosuite.runtime.EvoRunnerJUnit5;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.jupiter.api.extension.RegisterExtension;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.QuestionAnswer;

public class QuestionAnswer_ESTest{

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testSetQuestionCode()  throws Throwable  {
      QuestionAnswer<Object> questionAnswer0 = new QuestionAnswer<Object>();
      questionAnswer0.setQuestionCode("=eaB");
      String string0 = questionAnswer0.getQuestionCode();
      assertEquals("=eaB", string0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetQuestionCodeReturningEmptyString()  throws Throwable  {
      QuestionAnswer<Object> questionAnswer0 = new QuestionAnswer<Object>("", "");
      String string0 = questionAnswer0.getQuestionCode();
      assertEquals("", string0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetAnswerReturningNull()  throws Throwable  {
      QuestionAnswer<Object> questionAnswer0 = new QuestionAnswer<Object>();
      Object object0 = questionAnswer0.getAnswer();
      assertNull(object0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetAnswerReturningNonNull()  throws Throwable  {
      QuestionAnswer<Object> questionAnswer0 = new QuestionAnswer<Object>("", "");
      Object object0 = questionAnswer0.getAnswer();
      assertEquals("", object0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testSetAnswer()  throws Throwable  {
      QuestionAnswer<Object> questionAnswer0 = new QuestionAnswer<Object>("", "");
      questionAnswer0.setAnswer((Object) null);
      assertEquals("", questionAnswer0.getQuestionCode());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetQuestionCodeReturningNull()  throws Throwable  {
      QuestionAnswer<Integer> questionAnswer0 = new QuestionAnswer<Integer>();
      String string0 = questionAnswer0.getQuestionCode();
      assertNull(string0);
  }
}
