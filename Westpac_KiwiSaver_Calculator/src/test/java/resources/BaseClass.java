package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{

		prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Westpac_KiwiSaver_Calculator\\src\\test\\java\\com\\Westpac\\testData\\data.properties");

		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);

		if(browserName.equals("chrome"))
		{
			//execute in chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Westpac_KiwiSaver_Calculator\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();

		}
		else if (browserName.equals("firefox"))
		{
			//Execute in firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP\\eclipse-workspace\\Westpac_KiwiSaver_Calculator\\Drivers\\geckodriver.exe"); 
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
					}
		else if (browserName.equals("IE"))
		{
			//Execute in firefox
			System.setProperty("webdriver.ie.driver", "C:\\Users\\HP\\eclipse-workspace\\Westpac_KiwiSaver_Calculator\\Drivers\\IEDriverServer.exe"); 
			driver= new InternetExplorerDriver();
			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

		
			
	}
	
	
	/*
public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}*/

}
