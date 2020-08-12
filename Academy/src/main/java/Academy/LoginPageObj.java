package Academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObj {

	public WebDriver driver;

	@FindBy(xpath="//input[@id='user_email']")
	private WebElement email;

	@FindBy(xpath="//input[@id='user_password']")
	private WebElement pass;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement login;

	public LoginPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement emailId() {

		return email;
	}

	public WebElement password() {

		return pass;
	}

	public WebElement loginBtn() {

		return login;
	}

}
