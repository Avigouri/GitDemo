package myFirstFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateLogo extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		
	}
	@Test
	public void validateAppLogo() throws IOException
	{	
		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getLogo().isDisplayed());
		log.info("Logo dispayed as expected");

	
	}
	@Test
	public void suppressPopUp()
	{
		LandingPage l = new LandingPage(driver);
		l.getPopUp().click();
		log.info("NO Thanks clicked successfully");
	}
	
	@AfterTest
	public void teatdown()
	{
		driver.close();
		driver=null;
	}

	
}
	