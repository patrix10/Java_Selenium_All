import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Assignment7 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		
		//count n.o of rows in 1st table
		WebElement table = driver.findElement(By.id("product"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		
		//count n.o of columns
		System.out.println(table.findElements(By.tagName("th")).size());
		
		//add those numbers
		List<WebElement> values = table.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		int sum=0;
		
		for(int i=0;i<values.size();i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		Assert.assertEquals(sum, 235);
		
		//print 3rd row
		System.out.println(table.findElement(By.xpath("//div/fieldset/table/tbody/tr[3]")).getText());
	}
}