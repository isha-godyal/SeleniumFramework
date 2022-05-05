import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//how many iframes tag present
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//switch to frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		driver.findElement(By.id("draggable")).click();
		Actions a =new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
	}

}

// We can identify the frames in Selenium using methods given below:
// Right click on the element, If you find the option like ‘This Frame’ then it is an iframe.(Please refer the above diagram)
// Right click on the page and click ‘View Page Source’ and Search with the ‘iframe’, if you can find any tag name with the ‘iframe’ then it is meaning to say the page consisting an iframe.

// How to switch over the elements in iframes using Web Driver commands:

// the elements and handle frames in Selenium using 3 ways.
// By Index
// By Name or Id
// By Web Element

// Switch to the frame by index:

//Index is one of the attributes for frame handling in Selenium through which we can switch to it.

//Index of the iframe starts with ‘0’.

//Suppose if there are 100 frames in page, we can switch to frame in Selenium by using index.

//driver.switchTo().frame(0);
//driver.switchTo().frame(1);

//Switch to the frame by Name or ID:

//Name and ID are attributes for handling frames in Selenium through which we can switch to the iframe.

//driver.switchTo().frame(“iframe1”);
//driver.switchTo().frame(“id of the element”);

//Switch to the frame by Web Element:

//We can even switch to the iframe using web element .

//driver.switchTo().frame(WebElement);
//How to switch back to the Main Frame

//We have to come out of the iframe.

//To move back to the parent frame, you can either use switchTo().parentFrame() or if you want to get back to the main (or most parent) frame, you can use switchTo().defaultContent();

	    //driver.switchTo().parentFrame();
	    //driver.switchTo().defaultContent();

