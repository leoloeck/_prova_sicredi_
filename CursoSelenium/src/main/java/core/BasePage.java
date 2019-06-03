package core;

import static core.DriverFactory.getDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	static DriverFactory driverFactory = new DriverFactory();
	static WebDriver driver = driverFactory.start();
	
	public void escrever(By by, String texto){
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}
	
	public void escreverX(String id_campo, String texto){
		escrever(By.xpath(id_campo), texto);
	}
	
	public void escreverName(String name,String texto) {
		escrever(By.name(name), texto);
	}
	
	/********* Combo ************/
	
	public void selecionarCombo(String id, String valor) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chrome\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.get("http://www.grocerycrud.com/demo/bootstrap_theme");
		
		WebElement searchBox = driver.findElement(By.id("switch-version-select"));
		Select combo = new Select(searchBox);
		combo.selectByVisibleText("Bootstrap V4 Theme");
		
		//WebElement element = getDriver().findElement(By.id(id));
		//Select combo = new Select(element);
		//combo.selectByVisibleText(valor);
	}
	
	/********* Botao ************/
	
	public void clicarBotao(By by) {
		driver.findElement(by).click();
	}
	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}
	
	public void clicarBotaoPorTexto(String texto){
		clicarBotao(By.xpath(texto));
	}
	
	/********* Link ************/
	
	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	/********* Texto ************/
	
	public String obterTexto(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	/********* Outros ************/
	
	public void clicar(String campo) {
		driver.findElement(By.className(campo)).click(); 
	}
	
	public void deletando() {

		Robot r;
		try {
			r = new Robot();
			for (int i = 0; i < 10; i++) {
				r.keyPress(KeyEvent.VK_TAB);r.keyRelease(KeyEvent.VK_TAB);
				}
				
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} r.keyPress(KeyEvent.VK_ENTER);r.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clicarBotaoPorTexto("//p[contains(.,'Your data has been successfully deleted from the database.')]");

	}
	
	public void esperar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn btn-default btn-outline-dark")));
	}
	
	public void fim() {
		driver.quit();
		driver = null;
	}
}
