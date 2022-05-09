package programs;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
		
		//click on column 
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all webelement into list
		
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelements into new(original) list
		
		List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort in the list of step3-> sorted list
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//compare original vs sorted list
		
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;
		//scan the name column with getText->Rice->print the price of the Rice
		
		do
		{
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		 price = rows.stream().filter(s->s.getText().contains("Rice")).
		map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);
	}

	private static String getPriceVeggie(WebElement s) {

		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}



//What are Streams?
//Stream API is new feature available from java8 . By using streams, we can perform various aggregate operations 
//on the data returned from collections classes by drastically reduce the complexity of code

//What is Lambda Expression?
//Lambda expression introduce the new arrow operator -> into Java. It divides the lambda expression in two parts.
//The left side specifies the parameters required by the expression, which could also be empty if no parameters are required.
//The right side is the lambda body which specifies the actions of the lambda expression

//The working of stream can be explained in 3 stages:
//1. Create a Stream
//2. Perform intermediate operations on the initial stream to transform it into another stream and so on
//further intermediate operations
//3. Perform terminal operation on the final stream to get the result

//An important characteristic of intermediate operations is laziness.
//When executing this code snippet, nothing is printed to the console. i.e because intermediate operations
//will only be executed when a terminal operation is present.

//Note : The aggregate operations that we perform on the collection, array or any other data source do not
//change the data of the source, they simply return a new stream.