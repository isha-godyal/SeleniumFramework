import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\isha.godyal\\Downloads\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		int j=0;
		
		String[] itemsNeeded = {"Brocolli","Cucumber","Beetroot","Carrot"};
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
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
