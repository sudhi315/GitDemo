package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePage {
	
	
	public WebDriver driver;
	
	By courselinks = By.xpath("//div[@class='view-directory course-directory ']/div/div[2]//a");
	
	
	
	public CoursePage(WebDriver driver) 
	{
		this.driver=driver;
	}


	public List<WebElement> courselinks()
	{
		
		return driver.findElements(courselinks);
	}
}
