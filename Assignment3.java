package Week2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	public static void main(String arg[]) {

		//Webdriver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// URL login
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		
		// entering email and password
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// get the current title
		String title = driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		// Log out
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
	}
}
