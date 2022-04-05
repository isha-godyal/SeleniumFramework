import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {

		//Invoking Browser
		//Chrome - ChromeDriver extends ->Method close get
		//Firefox - FirefoxDriver ->Method close get
		//WebDriver methods + class methods
		
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		
//		//webdriver.chrome.driver->value of path
//		WebDriver driver = new ChromeDriver();
		
		//Firefox Driver
		//webdriver.gecko.driver
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\isha.godyal\\Downloads\\geckodriver-v0.30.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.close();  // close the current window
		
		//driver.quit(); //close all associated windows after test execution is done
		
	}

}
