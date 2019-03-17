package myFirstFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
				
	}
	@Test(dataProvider = "getData")
	public void baseBaseNavigation(String UserName, String PassWord, String text) throws IOException
	{	
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(UserName);
		lp.getPassword().sendKeys(PassWord);
		//System.out.println(text);
		log.info(text);
		lp.getSubmit().click();
		log.info("Login Message displayed successfully");
			
	}
	@AfterTest
	public void teatdown()
	{
		driver.close();
		driver=null;
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "restricted user";
				
		data[1][0] = "restricted@gmail.com";
		data[1][1] = "123456";
		data[1][2] = "norestricted user";
		
		return data;
		
	}
	
	
	
	
}
	