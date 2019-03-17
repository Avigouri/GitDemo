package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.xpath("//*[@id='content']/div/div/h2");
	By logo = By.xpath("/html/body/header/div[2]/div/div/a/img");
	By popup = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	public LandingPage(WebDriver driver) {
	
		this.driver = driver;
	}


	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getLogo()
	{
		return driver.findElement(logo);
	}
	
	public WebElement getPopUp() {
		// TODO Auto-generated method stub
		return driver.findElement(popup);
	}


}
