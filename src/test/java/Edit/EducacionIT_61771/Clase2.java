package Edit.EducacionIT_61771;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class Clase2 {
	String url = "http://automationpractice.pl";
	
	@Test
	public void registrarUsuario() {
		// Abrir el navegador
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		// Paso 1: Hacer clic en Sign In
		WebElement lnkSignIn = driver.findElement(By.partialLinkText("Sign"));
		lnkSignIn.click();
		
		//Otra forma de hacerlo
		//driver.findElement(By.partialLinkText("Sign")).click();
		
		//String email = "correo" + Math.random() + "@gmail.com";
		// Math.random() genera un número aleatorio en Java
		Faker faker = new Faker();
		String email = faker.internet().emailAddress();
		
		//faker.name().firstName();
		//faker.name().lastName();
		//faker.internet().password();
		
		// Paso 2: Escribir el correo y hacer clic en Create An Account
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email_create']"));
		txtEmail.sendKeys(email);
		
		WebElement btnCreate = driver.findElement(By.cssSelector("#SubmitCreate"));
		btnCreate.click();
		
		// Es necesaria una espera porque hay una demora en la carga del formulario
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		// Paso 3: Completar el formulario
		WebElement radTitle = driver.findElement(By.id("id_gender1")); // Título
		radTitle.click();
		
		WebElement txtFirstname = driver.findElement(By.id("customer_firstname")); // Nombre
		txtFirstname.sendKeys("Rafael");
		
		WebElement txtLastname = driver.findElement(By.name("customer_lastname")); // Apellido
		txtLastname.sendKeys("Gonzalez");
		
		WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']")); // Contraseña
		txtPassword.sendKeys("1q2w3e4r5t");
		
		Select selDays = new Select(driver.findElement(By.cssSelector("#days"))); // Día de Nacimiento
		selDays.selectByVisibleText("18  ");
		
		Select selMonths = new Select(driver.findElement(By.name("months"))); // Mes de Nacimiento
		selMonths.selectByValue("6");
		
		Select selYears = new Select(driver.findElement(By.id("years"))); // Año de Nacimiento
		selYears.selectByIndex(30);
		
		WebElement chkNewsletter = driver.findElement(By.cssSelector("#newsletter"));
		chkNewsletter.click();
		
		WebElement chkOffers = driver.findElement(By.xpath("//input[@id='optin']"));
		chkOffers.click();
		
		// Paso 4: Hacer clic en el botón Register
		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		btnRegister.click();
	}
}