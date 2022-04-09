import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_Popups {

	public static void main(String[] args) {

		String text = "Isha";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\isha.godyal\\Downloads\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();  // click on OK button
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();  // click on Cancel button

	}

}

// Alert Class Methods

//if you want to click on OK/YES --> accept() method
//if you want to click on NO/CANCEL --> dismiss() method