package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Intro2 {
	@Test(groups= {"Smoke"})
	public void Test3() {
		//Selenium Test
		System.out.println("Selenium Test");
	}
	@Test(dependsOnMethods= {"Test5"})
	public void Test4() {
		//Appium Test
		System.out.println("Appium Test");
	}
	@Test(groups= {"Smoke"})
	public void Test5() {
		//Api Test
		System.out.println("Api Test");
	}
	@Test(enabled=false)
	public void Test13() {
		//skip
		System.out.println("This will be skipped");
	}
	@Test(timeOut=8000)
	public void Test14() {
		//timeout
		System.out.println("i will occur after 8 sec only if there is error");
	}
	@Parameters({"URL","APIKey"})
	@Test
	public void Test15(String urlname,String Key) {
		System.out.println(urlname);
		System.out.println(Key);
	}
	@BeforeTest
	public void Test6() {
		//Before Test
		System.out.println("I Will Execute First inside this class");
	}
	@BeforeSuite
	public void Test7() {
		System.out.println("Before Suite");
	}
	@BeforeMethod
	public void Test9() {
		System.out.println("Before Method");
	}
	@AfterMethod
	public void Test10() {
		System.out.println("After Method");
	}
	@BeforeClass
	public void Test11() {
		System.out.println("Before Class, Once Before Every Class");
	}
	@AfterClass
	public void Test12() {
		System.out.println("After Class, Once After Every Class");
	}
}