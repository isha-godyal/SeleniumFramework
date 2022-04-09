import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
			//webdriver.chrome.driver->value of path
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			//dropdown with select tag
			//if tagname is "Select" then dropdown is static element
			//create an obj of select class and this obj as many methods in available class
			
			WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));  //webelement we get in var=staticDropdown
			Select dropdown = new Select(staticDropdown);  // pass var as argument
			
			//suppose to select by index
			dropdown.selectByIndex(3);
			System.out.println(dropdown.getFirstSelectedOption().getText());
			
			//suppose you want to select option by visible text
			dropdown.selectByVisibleText("AED");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			
			// you can also select based upon the attribute (value)
			dropdown.selectByValue("INR");
			System.out.println(dropdown.getFirstSelectedOption().getText());
	}

}


