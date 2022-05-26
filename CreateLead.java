package Week2Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


//  (//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]
// (//ul[@class='brand-list']/li/label/div)[1] or //label[text()='Flying Machine']/div
// //span[text()='Subject']/following::input 


public class CreateLead {
	public static void main(String[] arg) {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("DemoSalesManager");
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		
		driver.findElement(By.xpath("//input[contains(@id,'companyName')]")).sendKeys("TeaShop");
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Aadhiya");
		
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("Kia");
		
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("Verna");
		
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("SmartD");
		
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Creating Lead Form");
		
		driver.findElement(By.xpath("(//input[@name='primaryEmail'])[4]")).sendKeys("Aadhiya12@gmail.com");
		
		WebElement state = driver.findElement(By.xpath("//select[contains(@name,'StateProvince')]"));
		
		Select dd = new Select(state);
		
		dd.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		driver.close();
		
		
		
		
	}
}
