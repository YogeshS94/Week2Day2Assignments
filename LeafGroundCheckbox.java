package Week2Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundCheckbox {
	public static void main(String arg[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\60028440\\Documents\\TestLeaf\\Webdriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following-sibling::input[1]")).click();
		Boolean check1 = driver.findElement(By.xpath("//label[contains(text(),'Confirm Selenium')]/following-sibling::input")).isSelected();
		System.out.println("Confirm Selenium check box is selected: "+ check1);
		
		WebElement check2 = driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[2]"));
		check2.click();
		
		Boolean ch2 = check2.isEnabled();
		Boolean ch3 = check2.isSelected();
		
		System.out.println("Already selected check box is de-selected: "+!ch3);
		System.out.println("Is check box is Enabled: "+ch2);
		
		List<WebElement> options = driver.findElements(By.xpath("//label[contains(text(),'Select all')]/following-sibling::input"));
		
		for(int i=0; i<options.size(); i++) {
			WebElement option = options.get(i);
			option.click();
		}
		driver.close();
	}
}
