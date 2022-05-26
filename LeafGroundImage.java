package Week2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImage {
	public static void main(String arg[]) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/img)[1]")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img")).click();
		System.out.println(driver.getCurrentUrl());
		
		WebElement mouseAction = driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img"));
		Actions ac = new Actions(driver);
		ac.moveToElement(mouseAction).click().perform();
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}
}
