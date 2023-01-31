package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaContactUs;
import paginas.PaginaInicio;

public class Clase5bTest {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabraABuscar("dress");
		inicio.hacerClicEnBuscar();
	}
	
	@Test
	public void irAContactanos() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnContactUs();
		
		PaginaContactUs contact = new PaginaContactUs(driver);
		contact.seleccionarSubject("Webmaster");
		contact.escribirEmail("correo@gmail.com");
		contact.escribirOrder("123ABC");
		contact.escribirArchivo("C:\\addIntegerData.txt");
		contact.escribirMessage("Mensaje de Contacto");
		contact.clicEnEnviar();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
