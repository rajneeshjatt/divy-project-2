package Academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObj {

	WebDriver driver;

   	@FindBy(xpath = "//div[@class='sumome-react-svg-image-container']")
   	private WebElement join_newsletter_popup;

	@FindBy(linkText = "Login")
	private WebElement login_link;

	@FindBy(xpath = "//div[@class=\"text-center\"]/h2")
	private WebElement feature_text;

	public LandingPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement closeNewsletterPopup() {

		return join_newsletter_popup;
	}

	public WebElement login_btn() {

		return login_link;
	}

	public WebElement verify_feature_text() {

		return feature_text;
	}
}
