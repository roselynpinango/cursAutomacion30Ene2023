package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaContactUs {
	// Elementos
	@FindBy(id="id_contact")
	WebElement selSubject;
	
	@FindBy(name="id_order")
	WebElement txtOrder;
	
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='fileUpload']")
	WebElement filAttached;
	
	@FindBy(tagName="textarea")
	WebElement txtMessage;
	
	@FindBy(name="submitMessage")
	WebElement btnEnviar;
	
	public PaginaContactUs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void seleccionarSubject(String subject) {
		Select lista = new Select(selSubject);
		lista.selectByVisibleText(subject);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirOrder(String order) {
		txtOrder.sendKeys(order);
	}
	
	public void escribirArchivo(String ubicacion) {
		filAttached.sendKeys(ubicacion);
	}
	
	public void escribirMessage(String message) {
		txtMessage.sendKeys(message);
	}
	
	public void clicEnEnviar() {
		btnEnviar.click();
	}
	
	public void completarFormularioContactUs(
			String subject, String email, String order, 
			String ubicacion, String message) {
		Select lista = new Select(selSubject);
		lista.selectByVisibleText(subject);
		txtEmail.sendKeys(email);
		txtOrder.sendKeys(order);
		filAttached.sendKeys(ubicacion);
		txtMessage.sendKeys(message);
		btnEnviar.click();
	}
}
