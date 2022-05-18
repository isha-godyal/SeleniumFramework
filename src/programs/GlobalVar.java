package programs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalVar {

	public static void main(String[] args) throws IOException  {
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\isha.godyal\\workspace\\Introduction Selenium\\src\\data.properties");
	prop.load(fis);     //method is used to read
	System.out.println(prop.getProperty("browser"));
	System.out.println(prop.getProperty("url"));
	prop.setProperty("browser", "firefox");
	System.out.println(prop.getProperty("browser"));
	FileOutputStream fos = new FileOutputStream("C:\\Users\\isha.godyal\\workspace\\Introduction Selenium\\src\\data.properties");
	prop.store(fos, null);      //method is used to write
	
	
}
	
}
