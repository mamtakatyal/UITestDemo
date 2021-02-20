package TestNGProj;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestNGProj.ListenerUtil.class)
public class Test004 {
	@Test
	public void Test2() {
		System.out.println("This is test2 in test004 class");
		Assert.fail();
	}
	
	@Test
	public void Test3() {
		System.out.println("This is test3 in test004 class");
	}
	
	@Test(dependsOnMethods="Test2")
	public void Test1() {
		System.out.println("This is test1 in test004 class");
	}
}
