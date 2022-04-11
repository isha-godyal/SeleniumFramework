import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args) throws InterruptedException{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\isha.godyal\\Downloads\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
	    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    WebDriverWait w = new WebDriverWait(driver,5);
		
		String[] itemsNeeded = {"Brocolli","Cucumber","Beetroot","Carrot"};
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		
		addItems(driver,itemsNeeded);  //add the Utility where it accepts the array of input "String[] itemsNeeded" and add all items in the cart
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
		public static void addItems(WebDriver driver,String[] itemsNeeded )
		{
			int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size();i++)
		{
			//Brocolli - 1kg
			//Brocolli , 1 kg
			
			String[] name=products.get(i).getText().split("-");
			String formattedName = name[0].trim();   //trim the whitespace before '-'
			
			//format it to get actual vegetable name
			//Check whether name you extracted is present in array or not
			//convert Array into ArrayList for easy search
			
			   List itemsNeededList = Arrays.asList(itemsNeeded);
			   
			   
			if(itemsNeededList.contains(formattedName))
			{
				 j++;
				//click on Add to Cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==itemsNeeded.length)
					break;
			}
		}
		}

}


//Implicit Waits : Readable Code
// Implicit applied Globally as need to declare only once so no need to apply in each and every step in your Test Case
//Implicit wait have an effect to each and every steps
// Disadvantage : If any performance issues in your Web Application then you may not be noticed(Performance issues not caught)

//Explicit Waits : We are using explicit wait to target specific element and this explicit waits as no effect in any other steps
//1.To start with Explicit Wait : To define Web Driver wait class(which help us to achieve this explicit wait)
//2.Inside class you have to add 2 arguments (driver, how many seconds to wait)
//3. create an obj of that class so that you can access the method present in the class with that obj
// you have to wait until the element is visible on the screen
// No Performance issues
//More code to add

