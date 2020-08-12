package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializer() throws IOException {

		prop = new Properties();
		FileInputStream datafilepath = new FileInputStream(
				"H:\\Framework_Workspace\\Academy\\src\\main\\java\\resources\\data.properties");

		prop.load(datafilepath);

		//System.out.println(prop.getProperty("browser"));
		
		String browserName =System.getProperty("browser");
		

		if (browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			ChromeOptions option = new ChromeOptions();
			
			if(browserName.contains("headless")) {
				option.addArguments("headless");
			}
			
			driver = new ChromeDriver(option);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.firefox.driver", prop.getProperty("ffpath"));
			driver = new FirefoxDriver();
			
		}

		return driver;
	}
	
	public void screenShot(String TestcaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot shot = (TakesScreenshot) driver; 
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest = new File (System.getProperty("user.dir")+"\\reports\\"+TestcaseName +".png");
		Files.copy(src, dest);
	}

}
