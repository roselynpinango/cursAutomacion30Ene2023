package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase5cTest {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		// Hacer clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		// Ingresar las credenciales y hacer clic en Login
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		// Leer los datos del Excel y devolverlos en formato de Object[][]
		return DatosExcel.leerExcel("..\\EducacionIT-61771\\Datos\\Datos_Login.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[4][2];
		
		datos[0][0] = "abc@gmail.com"; 	// email
		datos[0][1] = "2rw3qrw4";		// password
		
		datos[1][0] = "def@gmail.com";
		datos[1][1] = "rthy6t5td";
		
		datos[2][0] = "ghi@gmail.com";
		datos[2][1] = "o9iu9l0";
		
		datos[3][0] = "jkl@gmail.com";
		datos[3][1] = "dsfdsafds";
		
		return datos;
	}
}
