package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;
import pageObjects.loginPage;

public class HomePage extends Base {
	
	private static Logger log =  LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test(dataProvider="getData")
	public void basehomepagenavigationn(String username,String password) throws IOException, InterruptedException
	{
		LandingPage lap = new LandingPage(driver);	
		Thread.sleep(5000);
		if(lap.nothanks().isDisplayed())
		{
		lap.nothanks().click();
		}
		lap.getlogin().click();
		
		
		loginPage lp = new loginPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		
		lp.clickLogin().click();
		
		log.info("able to successfully logged in");
		System.out.println("hello");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "12345";
		//data[0][2] = "restricteduser";
		
		
		return data;
	}
	@AfterTest
	public void clouser()
	{
		driver.close();
		driver=null;
	}
}
