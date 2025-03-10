package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Intro3 {
	@Test(dataProvider="getData")
	public void Provider(String username,String password) {
		System.out.println("Parameterization using DataProvider");
		System.out.println(username);
		System.out.println(password);
	}
	
	@DataProvider(name="getData")
	public Object[][] getData() {
		//1st combination (username,password)
		//2nd combination (username,password)
		//3rd combination (username,password)
		
		//we have 3 sets(rows) and each set has 2 values(columns)
		Object[][] data = new Object[3][2];
		//1st set
		data[0][0]="first username";
		data[0][1]="100";
		//2nd set
		data[1][0]="second username";
		data[1][1]="200";
		//3rd set
		data[2][0]="third username";
		data[2][1]="300";
		
		return data;
	}
}