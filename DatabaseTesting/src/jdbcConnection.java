import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcConnection {

	public static void main(String[] args) throws SQLException {
		String host = "localhost";
		String port = "3306";
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/EmployeePortal","root","pratik@12345");
		
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select * from credentials where scenario='rewardscard'");
		
		while(rs.next()) {   //index 0 to 1
			System.out.println(rs.getString("username"));   //username is string
			System.out.println(rs.getString("password"));   //password is string
			
			//Selenium
			WebDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			
			driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
			driver.findElement(By.id("Login")).click();
		}
	}
}