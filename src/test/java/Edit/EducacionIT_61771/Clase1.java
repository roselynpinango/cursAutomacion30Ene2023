package Edit.EducacionIT_61771;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase1 {
	// Atributos o Variables de Uso Común
	String url = "http://automationpractice.pl";
	
	// Método de Prueba
	@Test
	public void buscarPalabraEnChrome() {
		// Definir qué navegador quieres utilizar
		WebDriver driver = new ChromeDriver();
		
		// Abrir el navegador en la url que le indiques
		driver.get(url);  // ó driver.navigate().to(url); 
		driver.manage().window().maximize(); // maximiza
		driver.manage().deleteAllCookies(); // borra las cookies
		
		// Escribir una palabra en el buscador de la página
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER); // Simulo que se presiona la tecla ENTER	
	
		// Otra forma - Haciendo clic en la lupita
		//WebElement btnBuscar = driver.findElement(By.name("submit_search"));
		//btnBuscar.click();
		
		System.out.println(driver.getCurrentUrl()); // imprimir en consola
		System.out.println(driver.getTitle());
		
		driver.close(); // Cierra la ventana actual
		//driver.quit();  // Cierra todas las ventanas que se abrieron
	}
	
	@Test
	public void buscarPalabraEnFirefox() {
		// Definir qué navegador quieres utilizar
		WebDriver driver = new FirefoxDriver();
		
		// Abrir el navegador en la url que le indiques
		driver.get(url);
		
		// Escribir una palabra en el buscador de la página
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER); // Simulo que se presiona la tecla ENTER	
	
		// Otra forma - Haciendo clic en la lupita
		//WebElement btnBuscar = driver.findElement(By.name("submit_search"));
		//btnBuscar.click();
	}
	
	@Test
	public void buscarPalabraEnEdge() {
		// Definir qué navegador quieres utilizar
		WebDriver driver = new EdgeDriver();
		
		// Abrir el navegador en la url que le indiques
		driver.get(url);
		
		// Escribir una palabra en el buscador de la página
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER); // Simulo que se presiona la tecla ENTER	
	
		// Otra forma - Haciendo clic en la lupita
		//WebElement btnBuscar = driver.findElement(By.name("submit_search"));
		//btnBuscar.click();
	}
}
