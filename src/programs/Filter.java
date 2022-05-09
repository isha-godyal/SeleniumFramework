package programs;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter {

	public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
		
		//enter info in search box 
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		//how many columns displayed while searching the item and get those columns
		//select the generic xpath which gives the list of all elements
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));   //list of 5 webelements
		
		//all the elements go through this filter and whatever the element matches that filter 
		//and collect those in filter again and store it in new list
		List<WebElement> filteredList = veggies.stream().filter(veggie->veggie.getText().contains("Rice"))
		.collect(Collectors.toList());
		
		//filtered list have only 1 item result
		Assert.assertEquals(veggies.size(), filteredList.size());
	}

}
