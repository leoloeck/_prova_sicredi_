package pages;

import core.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.BasePage;

public class CustomersPage extends BasePage {
	
	public void selectVersion(String version) {
		selecionarCombo("switch-version-select",version);
	}
	
	public void adicionar() {
		clicarBotaoPorTexto(" //a[contains(@href, '/demo/bootstrap_theme_v4/add')]");
	}
	
	public void pesquisar(String nome) {
		clicarBotaoPorTexto("//form[@id='gcrud-search-form']/div/div[2]/a[3]/i");
		escreverName("search", nome);
		clicar("table-label");
		//escreverX(" //form[@id='gcrud-search-form']/div/div[2]/a[3]/i",nome);
	}
	
	public void espera() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void seleciona() {
		clicarBotaoPorTexto("(//input[@type='checkbox'])[2]");
	}
	
	public void deletar() {
		clicarBotaoPorTexto("//form[@id='gcrud-search-form']/div[2]/table/tbody/tr/td[2]/div/div/button");
		clicarBotaoPorTexto("//div/div/div/a[3]/i");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		deletando();
	}
	
	public String obterMensagem(){
		return obterTexto(By.xpath("//p[contains(.,'Your data has been successfully deleted from the database.')]"));
	}
}
