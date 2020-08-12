package Divy.Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resource.BaseClass;

public class HomePageTestCases extends BaseClass {

	public WebDriver driver;
	HomePageObjectRepository obj;
	private static final Logger log = LogManager.getLogger(HomePageTestCases.class);

	@BeforeTest
	public void browserInit() throws IOException, InterruptedException {

		driver = initialize();
		log.info("Browser initialized");
		driver.get(prop.getProperty("url"));
		log.info("Successfully passed the URL argument");
		Thread.sleep(20000);

	}

	@Test(priority = 1)
	public void titleVerification() throws InterruptedException {

		obj = new HomePageObjectRepository(driver);
		System.out.println(obj.getTitleName());
		log.info("Get HomePage Title Name");

		Assert.assertEquals(obj.getTitleName(), "Book Flights, Hotels, Deals & Activities Online | AirAsia");
		Thread.sleep(5000);

	}

	@Test(priority = 2)
	public void privacyLinkVerify() throws InterruptedException {
		obj = new HomePageObjectRepository(driver);
		Assert.assertTrue(obj.verifyLinkPresent(), "Privacy Statement link is not displayed");
		Thread.sleep(5000);

	}

	@Test(priority = 3)
	public void cookieCrossbtnVerify() throws InterruptedException {
		obj = new HomePageObjectRepository(driver);
		obj.btnVerify();
		Thread.sleep(5000);

	}

	@Test(priority = 4)
	public void flightBtnSelected() throws InterruptedException {
		obj = new HomePageObjectRepository(driver);
		Assert.assertTrue(obj.btnSelected(), "Flight button is not selected");
		Thread.sleep(5000);
	}
	
	@Test(priority = 5)
	public void languagedrpdown() {
		obj = new HomePageObjectRepository(driver);
		obj.langaugechk();

	}

	@AfterTest
	public void teardown() {
		obj = new HomePageObjectRepository(driver);
		driver.close();
	}
}
