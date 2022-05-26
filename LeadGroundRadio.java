package Week2Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadGroundRadio {
	public static void main(String arg[]) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/radio.html");
		WebElement yesRadio = driver.findElement(By.xpath("//input[@id='yes']"));
		yesRadio.click();
		Boolean yRadio = yesRadio.isSelected();
		if(yRadio) {
			System.out.println("yes button is selected");
		}
		else {
			System.out.println("yes button is not selected");
		}
		
		
		WebElement noRadio = driver.findElement(By.xpath("//input[@id='no']"));
		Boolean nRadio = noRadio.isSelected();
		System.out.println(nRadio);
		
		Boolean checkRadio = driver.findElement(By.xpath("(//input[@name='news'])[2]")).isSelected();
		if (checkRadio) {
			System.out.println("Correctly checked");
		}
		else {
			driver.findElement(By.xpath("(//input[@name='news'])[2]")).click();
		}
		
		List<WebElement> ages = driver.findElements(By.xpath("//input[@name='age']"));
		for(int i=0; i<ages.size(); i++) {
			WebElement age = ages.get(i);
			if (age.isSelected()) {
				System.out.println("Age is already selected");
				break;
			}
		}
		driver.close();
	}
}
