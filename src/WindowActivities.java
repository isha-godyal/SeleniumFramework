import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
			//webdriver.chrome.driver->value of path
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://google.com");
			driver.navigate().to("https://rahulshettyacademy.com");
			driver.navigate().back();
			driver.navigate().forward();
	}

}
