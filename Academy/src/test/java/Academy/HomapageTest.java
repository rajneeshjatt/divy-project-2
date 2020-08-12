package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.BaseClass;

public class HomapageTest extends BaseClass {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomapageTest.class.getName());

	LandingPageObj lp;
	LoginPageObj lj;

	@BeforeTest
	public void invokeBrowser() throws IOException {

		log.info("Invoking the Browser");
		driver = initializer();
		log.info("Browser invoked successfully");
	}

	@Test(dataProvider = "loginData")
	public void closingNewsPopup(String mail, String pas) throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		log.info("URL opened");
		lp = new LandingPageObj(driver);
		lp.login_btn().click();
		
		log.info("clicked on Login link");

		lj = new LoginPageObj(driver);

		lj.emailId().sendKeys(mail);
		log.info("Entered the Email Id");

		lj.password().sendKeys(pas);
		log.info("Entered Password");
		lj.loginBtn().click();
		log.info("clicked on Login button");

	}

	@AfterTest
	public void teardown() {

		driver.close();
		log.info("Browser Closed");

	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] {

				{ "FirstData@mail.com", "123456" }, { "SecondData@mail.com", "123456" }

		};

	}

}
