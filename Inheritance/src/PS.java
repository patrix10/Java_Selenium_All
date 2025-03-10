import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {
	public void doThis() {
		System.out.println("Parent Class");
	}
	@BeforeMethod
	public void before() {
		System.out.println("I will run before");
	}
	@AfterMethod
	public void after() {
		System.out.println("I will run after");
	}
}