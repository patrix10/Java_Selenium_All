package Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Intro {
	@AfterSuite
	public void Test8() {
		System.out.println("After Suite");
	}
	@AfterTest
	public void Test0() {
		System.out.println("I Will Execute Last inside this class");
	}
	@Test(groups= {"Smoke"})
	public void Test1() {
		System.out.println("Hello");
	}
	//Multiple test cases in single class
	@Test
	public void Test2() {
		System.out.println("Bye");
	}
}