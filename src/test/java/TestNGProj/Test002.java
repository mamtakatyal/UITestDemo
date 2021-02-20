package TestNGProj;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test002 {

/*	@Test
	public void Test2() {
		System.out.println("This is test2 in test002 class");
	}
	
	@Test
	public void Test3() {
		System.out.println("This is test3 in test002 class");
	}*/
	
	@Test(dataProvider="User")
	public void Test1(String name, String pass) {
		System.out.println("Parameters using data provider " + name + "  "+ pass );
	}
	@DataProvider(name="User")
	String [][] LoginData(){
		String [][] names= {{"mamta","admin"},{"admin","pass"}};
		return names;
	}
}
