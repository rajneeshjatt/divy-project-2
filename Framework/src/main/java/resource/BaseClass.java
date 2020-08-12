package resource;

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
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import com.google.common.io.Files;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initialize() throws IOException {

		String dir_path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(dir_path + "\\src\\main\\java\\resource\\Data.properties");

		prop = new Properties();
		prop.load(fis);

		String para_browser =  prop.getProperty("browser");  //System.getProperty("browser");

		if (para_browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", dir_path + "\\chromedriver.exe");

			ChromeOptions co = new ChromeOptions();
			if (para_browser.contains("headless")) {
				co.addArguments("headless");
			}

			driver = new ChromeDriver(co);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		} else if (para_browser.contains("firefox")) {
			System.setProperty("webdriver.chrome.driver", dir_path + "\\geckodriver.exe");

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else if (para_browser.contains("htmlunitdriver")) {

			driver = new HtmlUnitDriver(true); // We've set JavaScript code Execution enabled by setting argument to
												// true
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

		return driver;

	}

	public String captureScreenshot(String TestCaseName,WebDriver driver) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\reports\\" + TestCaseName + ".png";
		File dest = new File(path);  //System.getProperty("user.dir") + "\\reports\\" + TestCaseName + ".png");

		Files.copy(src, dest);
		
		return path;

	}

}
