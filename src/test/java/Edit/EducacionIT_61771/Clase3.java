package Edit.EducacionIT_61771;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Clase3 {
	String url = "http://automationpractice.pl";
	String dirEvidencias = "..\\EducacionIT-61771\\Evidencias\\";
	File imagen;
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1,description="CP01 - Ir a Contactanos")
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {	
		CapturaEvidencia.escribirTituloEnDocumento(
				dirEvidencias + "Evidencias-AutomationPractice.docx", 
				"Documento de Evidencias - Automation Practice", 
				18);
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + "Evidencias-AutomationPractice.docx",
				"Pantalla Principal");
		
		// Hacer clic en Contact us
		WebElement lnkContactUs = driver.findElement(By.linkText("Contact us"));
		lnkContactUs.click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + "Evidencias-AutomationPractice.docx",
				"Paso 1 - Luego de hacer clic en Contáctanos");
		
		// Completar el formulario
		Select selSubject = new Select(driver.findElement(By.xpath("//select[@id='id_contact']")));
		selSubject.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys("correo@gmail.com");
		
		WebElement txtOrder = driver.findElement(By.name("id_order"));
		txtOrder.sendKeys("1ABC");
		
		WebElement filAttached = driver.findElement(By.cssSelector("#fileUpload"));
		filAttached.sendKeys("C:\\addIntegerData.txt");
		
		WebElement tArMessage = driver.findElement(By.tagName("textarea"));
		tArMessage.sendKeys("Mensaje para contactar a la empresa");
				
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + "Evidencias-AutomationPractice.docx",
				"Paso 2 - Formulario Lleno");
		
		// Hacer clic en Send
		WebElement btnSend = driver.findElement(By.id("submitMessage"));
		btnSend.click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + "Evidencias-AutomationPractice.docx",
				"Paso 3 - Luego de enviar el formulario");
	}
	
	@Test(priority=2,description="CP02 - Buscar Palabra")
	public void buscarPalabra() throws IOException {
		// Captura de Evidencia
		imagen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imagen, new File(dirEvidencias + "01_pantallaPrincipal.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Captura de Evidencia
		imagen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imagen, new File(dirEvidencias + "02_palabraABuscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Captura de Evidencia
		imagen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(imagen, new File(dirEvidencias + "03_resultadoObtenido.jpg"));
		
		// Comprobacion de resultado esperado: Cambio en la URL
		String urlActual = driver.getCurrentUrl(); 
		String urlEsperada = "http://automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		
		Assert.assertEquals(urlActual, urlEsperada);
		
		String tituloActual = driver.getTitle();
		String tituloEsperado = "Search - My Store";
		
		Assert.assertEquals(tituloActual, tituloEsperado);
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		// Cerrar el navegador
		driver.close();
	}
}
