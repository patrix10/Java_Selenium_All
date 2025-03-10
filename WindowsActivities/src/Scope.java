import java.util.Set;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Count n.o of links on entire web-page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//count n.o of links only on footer section
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//sub-parts of footer section
		WebElement column = driver.findElement(By.xpath("//div/table/tbody/tr/td/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		
		//click on each link and open in separate page
		for(int i=1; i<column.findElements(By.tagName("a")).size(); i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(4000);
		}
		
		//get title of each link
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}