package Divy.Framework;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePageObjectRepository {

	public WebDriver driver;
	Select ls;

	@FindBy(xpath = "//div[@class='gdpr-wrapper-text']/a")
	WebElement privacylink;

	@FindBy(xpath = "//div[@class='gdpr-wrapper-parent']/child::div/div/a")
	WebElement privacystatement;

	@FindBy(xpath = "//div[@class='cross-wrapper']")
	WebElement crossbtn;

	@FindBy(xpath = "//button[@id=\"product-tile-flight\"]")
	WebElement flightbtn;

	@FindBy(xpath = "//span[@id='langDrop']")
	WebElement languagedrpdwn;

	public HomePageObjectRepository(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitleName() {

		return driver.getTitle();

	}

	public boolean verifyLinkPresent() {

		return privacystatement.isDisplayed();
	}

	public void btnVerify() {

		while (crossbtn.isDisplayed()) {
			crossbtn.click();
			System.out.println("Cross/close button is present and clicked");
			break;
		}

	}

	public boolean btnSelected() {

		String value = flightbtn.getAttribute("aria-selected");
		System.out.println(value);

		if (value.equalsIgnoreCase("true")) {
			return true;

		} else {

			return false;
		}

	}

	public void langaugechk() {

		Select ls = new Select(languagedrpdwn);

		

		java.util.List<WebElement> options = ls.getOptions();

		for (WebElement values : options) {

			System.out.println(values.getText());
		}

		System.out.println("Selected language is: " + ls.getFirstSelectedOption().getText());
	}

}
