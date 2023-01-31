package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase5Test {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		// Hacer clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		// Ingresar las credenciales y hacer clic en Login
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo@gmail.com");
		login.escribirPassword("1q2w3e4r5t");
		login.hacerClicEnLogin();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
