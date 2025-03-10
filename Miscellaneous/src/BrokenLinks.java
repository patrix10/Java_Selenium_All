import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	//	System.out.println(driver.findElement(By.linkText("SoapUI")).getDomAttribute("href"));
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		//Soft Assertion
		SoftAssert a = new SoftAssert();
		
		//Enhanced for loop
		for(WebElement link:links) {
			String url = link.getAttribute("href");
			//getAttribute is depricated but it is giving our desired output
			//getDomAttribute is giving error
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			if(respCode > 400) {
				System.out.println("Link with text"+link.getText()+"is broken with code"+respCode);
				a.assertTrue(false);
			}
		}
		a.assertAll();
	}
}