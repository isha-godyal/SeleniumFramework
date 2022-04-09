import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {

System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver\\chromedriver.exe");
		
		//webdriver.chrome.driver->value of path
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//FROM
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		
		//TO
		//driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
		//driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		//(//a[@value='MAA'])[2] -> through index also we can give xpath
		//parent-child relationship xpath -> //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
	}

}
