package Week2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {
	public static void main(String arg[]) throws InterruptedException {
		
		// Driver setup		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\60028440\\Documents\\TestLeaf\\Webdriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//Setting up the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//Login using the credentials
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		// enter the phone number to delete the lead created
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("777666555");
		driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[@class='x-btn-text' and text()='Find Leads']")).click();
		
		// waiting till the page loads to get the lead using phone number
		Thread.sleep(5000);
		
		// Select the first lead from searching and delete it
		WebElement firstLead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String fLead = firstLead.getText();
		System.out.println(fLead);
		firstLead.click();
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//div[@class='x-form-item x-tab-item']/div/input)[1]")).sendKeys(fLead);
		
		driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[@class='x-btn-text' and text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		// After the deleting the lead, confirm whether its deleted or not
		WebElement message = driver.findElement(By.xpath("(//div[@class='x-panel-bbar']//div)[2]"));
		
		String msg = message.getText();
		System.out.println(msg);
		if(msg.equals("No records to display")) {
			System.out.println("Successful");
		}
		else{
			System.out.println("Not Successful");
		}
		driver.close();
	}
}
