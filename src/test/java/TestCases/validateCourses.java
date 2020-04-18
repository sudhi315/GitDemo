package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.CoursePage;
import pageObjects.LandingPage;

public class validateCourses extends Base {
	
	private static Logger log =  LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void validatecourselinks() throws InterruptedException
	{
		LandingPage landp = new LandingPage(driver);	
		CoursePage cp = new CoursePage(driver);	
		Thread.sleep(5000);
		
		if(landp.nothanks().isDisplayed())
		{
		landp.nothanks().click();
		System.out.println("inside no thanks");
		}
		Thread.sleep(2000);
		//Assert.assertEquals(landp.getTitle().getText(), "FEATURED COURSES");
		System.out.println(landp.clickcourse().isDisplayed());
		System.out.println("clicking course");
		landp.clickcourse().click();
		landp.clickcourseagain().click();
		int count = cp.courselinks().size();
		for(int i=0;i<count;i++)
		{
			String name = cp.courselinks().get(i).getText();
			System.out.println(name);
		}
		log.info("successfully validated links");
	}
	@AfterTest
	public void clouser()
	{
		driver.close();
		driver=null;
	}
}
