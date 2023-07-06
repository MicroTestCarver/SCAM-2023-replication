/*
 * This file was automatically generated by EvoSuite
 * Mon May 15 15:16:23 GMT 2023
 */

package pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import org.evosuite.runtime.mock.java.time.MockClock;
import org.evosuite.runtime.mock.java.time.MockLocalDate;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.QuestionAnswer;

public class CalculatePriceCommand_ESTest {

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetSelectedCoversReturningListWhereIsEmptyIsTrue()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = new CalculatePriceCommand.CalculatePriceCommandBuilder();
      Stack<String> stack0 = new Stack<String>();
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder1 = calculatePriceCommand_CalculatePriceCommandBuilder0.selectedCovers(stack0);
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder1.build();
      List<String> list0 = calculatePriceCommand0.getSelectedCovers();
      assertEquals(0, list0.size());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetSelectedCoversReturningListWhereIsEmptyIsFalse()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = new CalculatePriceCommand.CalculatePriceCommandBuilder();
      Stack<String> stack0 = new Stack<String>();
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder1 = calculatePriceCommand_CalculatePriceCommandBuilder0.selectedCovers(stack0);
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder1.build();
      stack0.add(", policyFrom=");
      List<String> list0 = calculatePriceCommand0.getSelectedCovers();
      assertTrue(list0.contains(", policyFrom="));
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testCreatesCalculatePriceCommandTaking5Arguments()  throws Throwable  {
      ZoneId zoneId0 = ZoneId.systemDefault();
      LocalDate localDate0 = MockLocalDate.now(zoneId0);
      LinkedList<String> linkedList0 = new LinkedList<String>();
      CalculatePriceCommand calculatePriceCommand0 = new CalculatePriceCommand("", localDate0, localDate0, linkedList0, (List<QuestionAnswer>) null);
      String string0 = calculatePriceCommand0.getProductCode();
      assertEquals("", string0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetProductCodeReturningNull()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = new CalculatePriceCommand.CalculatePriceCommandBuilder();
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder0.build();
      String string0 = calculatePriceCommand0.getProductCode();
      assertNull(string0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testSetAnswers()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = new CalculatePriceCommand.CalculatePriceCommandBuilder();
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder0.build();
      calculatePriceCommand0.setAnswers((List<QuestionAnswer>) null);
      assertNull(calculatePriceCommand0.getProductCode());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetSelectedCoversReturningNull()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = new CalculatePriceCommand.CalculatePriceCommandBuilder();
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder0.build();
      List<String> list0 = calculatePriceCommand0.getSelectedCovers();
      assertNull(list0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetPolicyToReturningNull()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = new CalculatePriceCommand.CalculatePriceCommandBuilder();
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder0.build();
      LocalDate localDate0 = calculatePriceCommand0.getPolicyTo();
      assertNull(localDate0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testSetSelectedCovers()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = new CalculatePriceCommand.CalculatePriceCommandBuilder();
      Stack<String> stack0 = new Stack<String>();
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder0.build();
      calculatePriceCommand0.setSelectedCovers(stack0);
      assertTrue(stack0.isEmpty());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetAnswers()  throws Throwable  {
      CalculatePriceCommand calculatePriceCommand0 = new CalculatePriceCommand();
      List<QuestionAnswer> list0 = (List<QuestionAnswer>)calculatePriceCommand0.getAnswers();
      assertNull(list0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testSetPolicyTo()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = new CalculatePriceCommand.CalculatePriceCommandBuilder();
      LocalDate localDate0 = MockLocalDate.now();
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder0.build();
      calculatePriceCommand0.setPolicyTo(localDate0);
      assertNull(calculatePriceCommand0.getProductCode());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testSetPolicyFrom()  throws Throwable  {
      CalculatePriceCommand calculatePriceCommand0 = new CalculatePriceCommand();
      LocalDate localDate0 = MockLocalDate.now();
      calculatePriceCommand0.setPolicyFrom(localDate0);
      assertNull(calculatePriceCommand0.getProductCode());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testSetProductCode()  throws Throwable  {
      CalculatePriceCommand calculatePriceCommand0 = new CalculatePriceCommand();
      calculatePriceCommand0.setProductCode("io.micronaut.data.runtime.intercept.$DefaultFindOneInterceptor$Introspection");
      assertEquals("io.micronaut.data.runtime.intercept.$DefaultFindOneInterceptor$Introspection", calculatePriceCommand0.getProductCode());
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testGetPolicyFromReturningNull()  throws Throwable  {
      CalculatePriceCommand calculatePriceCommand0 = new CalculatePriceCommand();
      LocalDate localDate0 = calculatePriceCommand0.getPolicyFrom();
      assertNull(localDate0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testBuilderReturningNonNull()  throws Throwable  {
      Vector<String> vector0 = new Vector<String>();
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = CalculatePriceCommand.builder();
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder1 = calculatePriceCommand_CalculatePriceCommandBuilder0.selectedCovers(vector0);
      assertSame(calculatePriceCommand_CalculatePriceCommandBuilder0, calculatePriceCommand_CalculatePriceCommandBuilder1);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testPolicyFrom()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = CalculatePriceCommand.builder();
      Clock clock0 = MockClock.systemUTC();
      LocalDate localDate0 = MockLocalDate.now(clock0);
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder1 = calculatePriceCommand_CalculatePriceCommandBuilder0.policyFrom(localDate0);
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder1.build();
      LocalDate localDate1 = calculatePriceCommand0.getPolicyFrom();
      assertSame(localDate1, localDate0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testProductCode()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = new CalculatePriceCommand.CalculatePriceCommandBuilder();
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder1 = calculatePriceCommand_CalculatePriceCommandBuilder0.productCode("q=o5iOsxR");
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder1.build();
      String string0 = calculatePriceCommand0.getProductCode();
      assertEquals("q=o5iOsxR", string0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testToString()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = CalculatePriceCommand.builder();
      String string0 = calculatePriceCommand_CalculatePriceCommandBuilder0.toString();
      assertEquals("CalculatePriceCommand.CalculatePriceCommandBuilder(productCode=null, policyFrom=null, policyTo=null, selectedCovers=null, answers=null)", string0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testPolicyTo()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = new CalculatePriceCommand.CalculatePriceCommandBuilder();
      LocalDate localDate0 = MockLocalDate.now();
      calculatePriceCommand_CalculatePriceCommandBuilder0.policyTo(localDate0);
      CalculatePriceCommand calculatePriceCommand0 = calculatePriceCommand_CalculatePriceCommandBuilder0.build();
      LocalDate localDate1 = calculatePriceCommand0.getPolicyTo();
      assertSame(localDate1, localDate0);
  }

  @Test
  @Timeout(value = 4000 , unit = TimeUnit.MILLISECONDS)
  public void testAnswers()  throws Throwable  {
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder0 = CalculatePriceCommand.builder();
      CalculatePriceCommand.CalculatePriceCommandBuilder calculatePriceCommand_CalculatePriceCommandBuilder1 = calculatePriceCommand_CalculatePriceCommandBuilder0.answers((List<QuestionAnswer>) null);
      assertSame(calculatePriceCommand_CalculatePriceCommandBuilder0, calculatePriceCommand_CalculatePriceCommandBuilder1);
  }
}