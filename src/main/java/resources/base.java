package resources;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		 
		 prop = new Properties();
		 FileInputStream fis = new FileInputStream("C:\\Users\\Avinash\\E2EProject\\src\\main\\java\\resources\\data.properties");
		 prop.load(fis);
		 String browserName = prop.getProperty("browser");
		 
		 if(browserName.equals("chrome"))
		 {
			 
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\Downloads\\chromedriver.exe");
			 driver = new ChromeDriver();
			 
		 }else if(browserName.equals("gecko"))
			 
		 {
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Avinash\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 
		 }else if(browserName.equals("ie"))
			 
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Avinash\\Downloads\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 return driver;
	 }
	public void getScreenshot(String result) throws IOException
	{
	
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("C://Users//Avinash//Documents//Screenshots//"+result+"screenshot.png"));
		
	}
   
}
