import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//TestNG is one of the testing framework

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//webdriver.chrome.driver->value of path
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//Assert.assertFalse(false);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//a.ui-state-default.ui-state-highlight
		//click on round trip checkbox
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("its enabled");
			    Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
		//click on return calender date
		
		Thread.sleep(3000);
		//Count the num of Checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		
		int i=1;
		while(i<5)  {
			
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		// same can do for loop
//		for(i=1;i<5;i++)  {
	//		driver.findElement(By.id("hrefIncAdt")).click();
	//	}
		
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}

//Assertions

// Validate the results which was being written by selenium with expected result

