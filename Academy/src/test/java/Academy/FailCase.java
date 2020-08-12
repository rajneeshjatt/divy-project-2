package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.BaseClass;

public class FailCase extends BaseClass{

	public WebDriver driver;

	LandingPageObj lp;

	@BeforeTest
	public void invokeBrowser() throws IOException {

		driver = initializer();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void failvalidateTitle() {

		lp = new LandingPageObj(driver);
		Assert.assertEquals(lp.verify_feature_text().getText(), prop.getProperty("feature_fail_title"));

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}
}
