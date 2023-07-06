/*
 * This file was automatically generated by EvoSuite
 * Mon Jan 09 23:08:17 GMT 2023
 */

package alfio.controller.support;

import alfio.controller.api.support.PageAndContent;
import alfio.controller.api.support.PageAndContent_ESTest_scaffolding;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class PageAndContent_ESTest extends PageAndContent_ESTest_scaffolding {

  @Test
  public void testEqualsAndEqualsReturningTrue0()  throws Throwable  {
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>((Integer) null, (Integer) null);
      PageAndContent<Object> pageAndContent1 = new PageAndContent<Object>(pageAndContent0, (Integer) null);
      PageAndContent<Object> pageAndContent2 = new PageAndContent<Object>(pageAndContent0, (Integer) null);
      boolean boolean0 = pageAndContent1.equals(pageAndContent2);
      assertTrue(boolean0);
  }

  @Test
  public void testGetRightReturningZero()  throws Throwable  {
      Integer integer0 = new Integer(0);
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>(integer0, integer0);
      PageAndContent<Object> pageAndContent1 = new PageAndContent<Object>(pageAndContent0, integer0);
      Integer integer1 = pageAndContent1.getRight();
      assertEquals(0, (int)integer1);
  }

  @Test
  public void testGetRightReturningNull()  throws Throwable  {
      Integer integer0 = new Integer(839);
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>(integer0, (Integer) null);
      Integer integer1 = pageAndContent0.getRight();
      assertNull(integer1);
  }

  @Test
  public void testGetRightReturningNegative()  throws Throwable  {
      Integer integer0 = new Integer((-254));
      PageAndContent<Object> pageAndContent0 = new PageAndContent<Object>(integer0, integer0);
      Integer integer1 = pageAndContent0.getRight();
      assertEquals((-254), (int)integer1);
  }

  @Test
  public void testGetLeftReturningNull()  throws Throwable  {
      Integer integer0 = new Integer(0);
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>((Integer) null, integer0);
      Object object0 = pageAndContent0.getLeft();
      assertNull(object0);
  }

//  @Test
//  public void testCanEqualReturningTrue()  throws Throwable  {
//      Integer integer0 = new Integer(1513);
//      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>(integer0, (Integer) null);
//      PageAndContent<Object> pageAndContent1 = new PageAndContent<Object>(integer0, (Integer) null);
//      boolean boolean0 = pageAndContent1.canEqual(pageAndContent0);
//      assertTrue(boolean0);
//  }

//  @Test
//  public void testCanEqualReturningFalse()  throws Throwable  {
//      Integer integer0 = new Integer(1513);
//      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>(integer0, (Integer) null);
//      PageAndContent<Object> pageAndContent1 = new PageAndContent<Object>(pageAndContent0, integer0);
//      boolean boolean0 = pageAndContent1.canEqual(integer0);
//      assertFalse(boolean0);
//  }

  @Test
  public void testGetRightReturningPositive()  throws Throwable  {
      Integer integer0 = new Integer(1);
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>(integer0, integer0);
      Integer integer1 = pageAndContent0.getRight();
      assertEquals(1, (int)integer1);
  }

  @Test
  public void testGetLeftReturningNonNull()  throws Throwable  {
      Integer integer0 = new Integer(1);
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>(integer0, integer0);
      PageAndContent<Object> pageAndContent1 = new PageAndContent<Object>(integer0, integer0);
      PageAndContent<PageAndContent<Integer>> pageAndContent2 = new PageAndContent<PageAndContent<Integer>>(pageAndContent0, integer0);
      Object object0 = pageAndContent2.getLeft();
      boolean boolean0 = pageAndContent1.equals(object0);
      assertTrue(boolean0);
  }

  @Test
  public void testEqualsAndEqualsReturningFalse0()  throws Throwable  {
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>((Integer) null, (Integer) null);
      PageAndContent<Object> pageAndContent1 = new PageAndContent<Object>(pageAndContent0, (Integer) null);
      boolean boolean0 = pageAndContent0.equals(pageAndContent1);
      assertFalse(boolean0);
  }

  @Test
  public void testEqualsAndEqualsReturningFalse1()  throws Throwable  {
      Integer integer0 = new Integer((-1));
      Object object0 = new Object();
      PageAndContent<Object> pageAndContent0 = new PageAndContent<Object>(object0, integer0);
      Integer integer1 = new Integer(0);
      PageAndContent<Object> pageAndContent1 = new PageAndContent<Object>(pageAndContent0, integer1);
      boolean boolean0 = pageAndContent0.equals(pageAndContent1);
      assertFalse(boolean0);
  }

  @Test
  public void testEqualsAndEqualsReturningFalse2()  throws Throwable  {
      Integer integer0 = new Integer(0);
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>(integer0, integer0);
      PageAndContent<Object> pageAndContent1 = new PageAndContent<Object>((Object) null, (Integer) null);
      boolean boolean0 = pageAndContent1.equals(pageAndContent0);
      assertFalse(boolean0);
  }

  @Test
  public void testEqualsAndEqualsReturningFalse3()  throws Throwable  {
      Integer integer0 = new Integer(1);
      PageAndContent<Object> pageAndContent0 = new PageAndContent<Object>(integer0, integer0);
      PageAndContent<PageAndContent<Object>> pageAndContent1 = new PageAndContent<PageAndContent<Object>>(pageAndContent0, integer0);
      boolean boolean0 = pageAndContent1.equals(pageAndContent0);
      assertFalse(boolean0);
  }

  @Test
  public void testEqualsWithNull()  throws Throwable  {
      Integer integer0 = new Integer(1);
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>(integer0, integer0);
      boolean boolean0 = pageAndContent0.equals((Object) null);
      assertFalse(boolean0);
  }

  @Test
  public void testHashCode0()  throws Throwable  {
      Integer integer0 = new Integer(0);
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>((Integer) null, integer0);
      pageAndContent0.hashCode();
  }

  @Test
  public void testHashCode1()  throws Throwable  {
      Integer integer0 = new Integer(839);
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>(integer0, (Integer) null);
      pageAndContent0.hashCode();
  }

  @Test
  public void testToString()  throws Throwable  {
      Integer integer0 = new Integer(0);
      PageAndContent<PageAndContent<Object>> pageAndContent0 = new PageAndContent<PageAndContent<Object>>((PageAndContent<Object>) null, integer0);
      String string0 = pageAndContent0.toString();
      assertEquals("PageAndContent(left=null, right=0)", string0);
  }

  @Test
  public void testEqualsAndEqualsReturningTrue2()  throws Throwable  {
      PageAndContent<Integer> pageAndContent0 = new PageAndContent<Integer>((Integer) null, (Integer) null);
      PageAndContent<Object> pageAndContent1 = new PageAndContent<Object>((Object) null, (Integer) null);
      boolean boolean0 = pageAndContent1.equals(pageAndContent0);
      assertTrue(boolean0);
  }
}
