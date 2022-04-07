import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//webdriver.chrome.driver->value of path
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}

}


// Absolute Xpath - Start from the top main parent (HTML tag) root object starts traversing towards child
// For Absolute Xpath start with '/' means starting from roots of this html

// Relative Xpath - Starts from the middleware down (relatively pointing to the position)
// starts with '//'
// //header/div/button[1]/following-sibling::button[1]
// parent to child -> //header/div/button[1]   sibling to sibling -> /following-sibling::button[1]
// child to parent -> //header/div/button[1]/parent::div 
// from parent to grant parent to child -> //header/div/button[1]/parent::div/parent::header/a