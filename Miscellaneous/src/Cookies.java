import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {

	public static void main(String[] args) throws IOException{
		WebDriver driver = new ChromeDriver();
		//delete all cookie
		driver.manage().deleteAllCookies();
		//delete single cookie
		driver.manage().deleteCookieNamed("asdf");
	/*  delete session cookie
		driver.manage().deleteCookieNamed("sessionKey");
		 //click on any link
		 //login page verify login-url   */
		
		driver.get("https://www.uefa.com/uefachampionsleague/");
		
		//Take screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("screenshot.png"));
	}
}