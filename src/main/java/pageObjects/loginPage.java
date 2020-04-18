package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	By email = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By loginBtn = By.xpath("//input[@name='commit']");
	
	
	public loginPage(WebDriver driver) 
	{
		this.driver=driver;
	}


	public WebElement getUsername()
	{
		
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		
		return driver.findElement(password);
	}
	
	public WebElement clickLogin()
	{
		
		return driver.findElement(loginBtn);
	}

}
