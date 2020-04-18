package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;

public class validateTitle extends Base {
	
	private static Logger log =  LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void featuretitle() throws IOException
	{
		
		LandingPage landp = new LandingPage(driver);		
		Assert.assertEquals(landp.getTitle().getText(), "FEATURED COURSES");
		log.info("successfully validated text titel");
	}
	@AfterTest
	public void clouser()
	{
		driver.close();
		driver=null;
	}
}
