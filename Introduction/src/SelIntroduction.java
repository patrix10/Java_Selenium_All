import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		//invoking browser
		WebDriver driver = new ChromeDriver();
       // using selenium manager or manually giving the path
		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
		
		int[] ar = new int[3];
		ar[0]=5;
		ar[1]=7;
		ar[2]=9;
	
		int[] arr = {4,9,67,34,2};
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		ArrayList<String> a  = new ArrayList<String>();
		a.add("pratik");
		a.add("vedansh");
		a.add("singh");
		System.out.println(a);
		
		for(int i=0;i<a.size();i++) {
			System.out.println(a.contains("pratik"));
			
		List<int[]> newArr = Arrays.asList(arr);
		System.out.println(newArr);
		}
		
		String s = "abc";
		System.out.println(s);
		
		//Access methods 
		SelIntroduction obj = new SelIntroduction();
		obj.getData();
		obj.gotData();
		gData();
	}
	public void getData() {
		System.out.println("Hello how are you");
	}
	public String gotData() {
		return "hi my name is pratik";
	}
	public static String gData() {      //will behave like a class
		return "pratik";
	}
}