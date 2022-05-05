import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException  {

System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");    // scrolls the window 
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");    //scrolls the inner table
		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<values.size();i++)
		{
			sum = sum+Integer.parseInt(values.get(i).getText());    // change the String value into Integer
		}
		System.out.println(sum);
		
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
	}
	


}




// A Scroll is a JavaScript method. The JavaScriptExecutor provides an interface that enables QAs to run JavaScript methods from Selenium scripts. 
// Hence, to scroll up or down with Selenium, a JavaScriptExecutor is a must.
// To scroll using Selenium, you can use JavaScriptExecutor interface that helps to execute JavaScript methods through Selenium Webdriver

// Syntax :JavascriptExecutor js = (JavascriptExecutor) driver;  
                //js.executeScript(Script,Arguments);
// Script – This is the JavaScript that needs to execute.
// Arguments – It is the arguments to the script. It’s optional.

// The syntax of ScrollBy() methods is :
//executeScript("window.scrollBy(x-pixels,y-pixels)");

// If a user needs to scroll down they just need to modify the pixel value of the 2nd parameter by positive value (0,1000)
// js.executeScript("window.scrollBy(0,1000)"); //Scroll vertically down by 1000 pixels

// If a user needs to scroll up they just need to modify the pixel value of the 2nd parameter by negative value (0,-1000)
// js.executeScript("window.scrollBy(0,-1000)"); //Scroll vertically up by 1000 pixels

// to scroll down to the bottom of the webpage using Selenium - It will fetch the maximum height of the webpage from the Document Object Model, and then the scrollBy() method scrolls down to the bottom.
// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
// “document.body.scrollHeight” returns the complete height of the body i.e web page.

// scroll the page until the mentioned element is visible on the current page. Javascript method scrollIntoView() scrolls the page until the mentioned element is in full view :
// js.executeScript("arguments[0].scrollIntoView();",Element );
// “arguments[0]” means first index of page starting at 0.
// Where an ” Element ” is the locator on the web page.

//  Horizontal scroll on the web page.
//  scroll the page horizontally until the mentioned element is visible on the current page. Javascript method scrollIntoView() scrolls the page until the mentioned element is in full view :
// js.executeScript("arguments[0].scrollIntoView();",Element );

