package TestNGProj;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGHardAssert {

	@Test
	public void Test1() {
		
		//Assert.assertEquals("Hello", "Hello","Message does not match");
		
		//Assert.assertTrue(5<8, "It is not true");
		
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals("Hello","hello", "Does not match");
		
		sa.assertTrue(5>8, "matches");
		System.out.println("this is a message");
		sa.assertAll();
		
	}
}
