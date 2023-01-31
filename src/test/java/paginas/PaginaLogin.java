package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtPassword;
	
	@FindBy(css="#SubmitLogin")
	WebElement btnLogin;
	
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void hacerClicEnLogin() {
		btnLogin.click();
	}
	
	public void ingresarCredenciales(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
