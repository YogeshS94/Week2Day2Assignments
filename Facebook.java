package Week2Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {
	public static void main(String arg[]) {
		// setting the driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\60028440\\Documents\\TestLeaf\\Webdriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//loading the url
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		//adding implicity wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// press create account button
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		
		// entering first name, last name, email, password
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Aadhiya");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kast");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("8807413266");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("YAadhiya!&");
		
		// selecting Day, month, year
		WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
		Select dropD = new Select(day);
		dropD.selectByValue("3");
		WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
		Select dropDM = new Select(month);
		dropDM.selectByVisibleText("Jun");
		WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
		Select dropDY = new Select(year);
		dropDY.selectByValue("1994");
		
		// selecting female radio button
		driver.findElement(By.xpath("(//input[@class='_8esa'])[1]")).click();
		
		driver.close();
	}
}
