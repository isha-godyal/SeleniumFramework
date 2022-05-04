import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLogin {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//webdriver.chrome.driver->value of path
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.flipkart.com/");
		
		
		//   //a[contains(@href,'/account/login')]
		boolean loginPopupDisplayed = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).isDisplayed();
		if(!loginPopupDisplayed) {
			driver.findElement(By.xpath("//a[contains(@href,'/account/login')]")).click();
		}
		
//		driver.findElement(By.xpath("//a[text()='Login']")).click();
		System.out.println("login popup loaded");
		
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("9764125298");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("sHEKHAR@4256");
		driver.findElement(By.xpath("//span[text()='Login']//parent::button[@type='submit']")).click();
		
	}

}
