import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
	
		//webdriver.chrome.driver->value of path
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("submit")).click();
		//Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("isha");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("isha@rsa.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("isha@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9674125298");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
//		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-container']/button[1]")).click();
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		//driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-container']/button[1]"))
		
		
//		form p -> cssselector
		//driver.close();
	}

}

// Using CSSSelector Different Ways

// 1. CSS Selector ---> tagname.classname
// 2. Id-> tagname#id  -> input#inputUsername   
// 3. tagname[attribute='value']
// for eg -> <input type="text" placeholder="Username" value="">
// Input[placeholder='Username']
// 4. for Input[placeholder='Username']  -> //tagname[@attribute='value']:nth-child(index) -> Child items
// 5. parenttagname childtagname
// 6. input[type*='pass']
// 7. tagname
// 8. No element is identified based upon the text
// 9. Child to parent is not possible -> disadvantage

// For Xpath

//  1. "//tagname[@attribute='value']"
//  2. "//parenttagname/childtagname"
//  3. "//tagname[@attribute='value'][index]"
//  4. "//button[contains(@class,'submit')]"  -> Regular Expression
//  5.  if you want to treat tagname as a Xpath -> //tagname   or you can simply use as a tagname attribute
//  6.  Identified the element based upon the text -> //button[text()='Log Out']