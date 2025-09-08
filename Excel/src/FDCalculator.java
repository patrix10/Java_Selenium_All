import java.io.IOException;

import java.time.Duration;
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.Select;
 
public class FDCalculator {
 
	public static void main(String[] args) throws IOException, InterruptedException {
 
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");


		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.moneycontrol.com/fixed");

		String filePath = System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";

		int rows = ExcelUtils.getRowCount(filePath, "sheet1");

		for(int i=1; i<=rows; i++) {

			// 1) Read data from excel

			String priAmt = ExcelUtils.getCellData(filePath, "sheet1", i, 0);

			String rateOfInterest = ExcelUtils.getCellData(filePath, "sheet1", i, 1);

			String period1 = ExcelUtils.getCellData(filePath, "sheet1", i, 2);

			String period2 = ExcelUtils.getCellData(filePath, "sheet1", i, 3);

			String freq = ExcelUtils.getCellData(filePath, "sheet1", i, 4);

			String exp_mvalue = ExcelUtils.getCellData(filePath, "sheet1", i, 5);

			// 2) Pass above excel data into application

			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(priAmt);

			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);

			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);

			Select perdrp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));

			perdrp.selectByVisibleText(period2);

			Select fredrp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));

			fredrp.selectByVisibleText(freq);

			//Click on Calculate button

			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();


			// Validation

			String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();

			if(Double.parseDouble(exp_mvalue)== Double.parseDouble(act_mvalue)) {

				System.out.println("Test Passed");

				ExcelUtils.setCellData(filePath, "sheet1", i, 7, "Passed");

			}

			else {

				System.out.println("Test Failed");

				ExcelUtils.setCellData(filePath, "sheet1", i, 7, "Failed");

			}


			Thread.sleep(3000);

			//Click on Clear Button

			driver.findElement(By.xpath("//img[@class='PL5']")).click();

		}//end of for loop

		driver.quit();

	}

}

 