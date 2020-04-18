package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	By signin = By.xpath("//span[contains(text(),'Login')]");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navbar = By.xpath("//nav[@class='navbar-collapse collapse']");
	By nothanks = By.xpath("//*[contains(text(),'NO THANKS')]");
	By course = By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[contains(text(),'Courses')]");
	By secondcourselink = By.xpath("//div[@class='nav-outer clearfix']//a[contains(text(),'Courses')]");
	
	
	public LandingPage(WebDriver driver) 
	{
		this.driver=driver;
	}


	public WebElement getlogin()
	{
		
		return driver.findElement(signin);
	}

	public WebElement getTitle()
	{
		
		return driver.findElement(title);
	}
	
	public WebElement checknavbar()
	{
		
		return driver.findElement(navbar);
	}
	
	public WebElement nothanks()
	{
		
		return driver.findElement(nothanks);
	}
	
	public WebElement clickcourse()
	{
		
		return driver.findElement(course);
	}
	
	public WebElement clickcourseagain()
	{
		
		return driver.findElement(secondcourselink);
	}
	
}
