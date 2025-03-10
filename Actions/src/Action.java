import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		WebElement capital = driver.findElement(By.id("twotabsearchtextbox"));
		//To move to a specific element [hover]
		a.moveToElement(move).build().perform();
		//To write in capital letters and double click
		a.moveToElement(capital).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//To right click
		a.moveToElement(move).contextClick().build().perform();
	}
}
