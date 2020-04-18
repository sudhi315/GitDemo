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

public class validatenavigationbar extends Base{
	private static Logger log =  LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void navbar() throws IOException
	{
		
		LandingPage landp = new LandingPage(driver);
		Assert.assertTrue(landp.checknavbar().isDisplayed());	
		log.info("successfully validated nagigation bar");
	}
	
	@AfterTest
	public void clouser()
	{
		driver.close();
		driver=null;
	}
}
