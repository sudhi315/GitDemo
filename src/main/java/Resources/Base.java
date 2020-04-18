package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public WebDriver driver;
	public Properties prop;	
	
	public WebDriver initializeDriver() throws IOException 
	{
		//System.out.println(System.getProperty("user.dir"));
		prop = new Properties();
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);

		//String browser = prop.getProperty("browser");
		String browser = System.getProperty("browser");
		
		
		String url = prop.getProperty("url");

		if (browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browser.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);			
			driver.manage().window().maximize();
		} else if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browser.contains("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
        	
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"\\test\\Screenshot\\"+result+"screenshot.png"));
		
	}

}
