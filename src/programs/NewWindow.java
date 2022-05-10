package programs;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws IOException {

		//Invoking Multiple Windows/Tabs from Selenium using one driver Instance
		
		//Scenario 1: Navigate to https://rahulshettyacademy.com/angularpractice/
		//Fill the "Name" field with the first course name available at "https://rahulshettyacademy.com/"
		
		
		
		//a[href*='https://courses.rahulshettyacademy.com/p']
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/resources/drivers/chromedriver.exe");
			
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handels = driver.getWindowHandles();
		Iterator<String> it = handels.iterator();
		String parentWindowId = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		
		//Scenario 2: Capture WebElement Screenshot using Selenium
		//Get Height Width of Web Element using Selenium
		File file = name.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("logo.png"));
		//driver.quit();
		
		
		
	}

}
