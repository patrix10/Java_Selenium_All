import java.util.Set;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String DefaultWindow = it.next();
		String NextWindow = it.next();
		driver.switchTo().window(NextWindow);
		
		System.out.println(driver.findElement(By.className("example")).getText());
		driver.switchTo().window(DefaultWindow);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
	}
}
