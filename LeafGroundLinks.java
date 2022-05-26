package Week2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLinks {
	public static void main(String arg[]) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//a[contains(text(), 'Find where')]")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//button[@id='home']")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight']/h5[text()='HyperLink']")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//a[contains(text(),'broken')]")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
	}
}
