import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// broken Url
		// step 1- Is to get all urls tied up to the links using selenium
		// Java methods will call URL's and gets you the status code
		// if status code > 400 then that url is not working -> link which tied to url is broken
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			//String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
			// "a[href*='brokenlink']" -> check with this link
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400,"The link with Text"+link.getText()+"is broken with code"+respCode);
			
		}
		
		a.assertAll();
	}

}


// What are Broken Links?
// Broken links are links or URLs that are not reachable.
// They may be down or not functioning due to some server error


// How to check the Broken Links and images
// For checking the broken links, you will need to do the following steps.

// 1.Collect all the links in the web page based on <a> tag.
// 2.Send HTTP request for the link and read HTTP response code.
// 3.Find out whether the link is valid or broken based on HTTP response code.
// 4.Repeat this for all the links captured.









