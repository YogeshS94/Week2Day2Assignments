package Week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {
	public static void main(String arg[]) throws InterruptedException {
		
		// Driver setup			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\60028440\\Documents\\TestLeaf\\Webdriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("yogeshvasan94@gmail.com");
		
		driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[@class='x-btn-text' and text()='Find Leads']")).click();

		Thread.sleep(5000);
		
		WebElement firstLead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		
		WebElement name = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[text()='yogesh'])[1]"));
		String fName = name.getText();
		System.out.println(fName);
		firstLead.click();
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		Thread.sleep(5000);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.contains("Duplicate Lead")) {
			System.out.println("Title is: "+ title);
		}
		else {
			System.out.println("Title is wrong: "+ title);
		}
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String duplicateName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println(duplicateName);
		if(fName.equals(duplicateName)) {
			System.out.println("Both names are equal");
		}
		else {
			System.out.println("Both names are not equal");
		}
		driver.close();
	}
}
