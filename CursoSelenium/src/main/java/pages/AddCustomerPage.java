package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class AddCustomerPage extends BasePage {

	public void setNome(String nome){
		escrever("field-customerName", nome);
	}
	
	public void setLastName(String nome) {
		escrever("field-contactLastName", nome);
	}
	
	public void setFirstName(String nome) {
		escrever("field-contactFirstName", nome);
	}
	
	public void setFone(String nome) {
		escrever("field-phone", nome);
	}
	
	public void setAdress(String nome) {
		escrever("field-addressLine1", nome);
	}
	
	public void setAdress2(String nome) {
		escrever("field-addressLine2", nome);
	}
	
	public void setCity(String nome) {
		escrever("field-city", nome);
	}
	
	public void setState(String nome) {
		escrever("field-state", nome);
	}
	
	public void setPostal(String nome) {
		escrever("field-postalCode", nome);
	}
	
	public void setCountry(String nome) {
		escrever("field-country", nome);
	}
	
	public void setEmployeer() {
		try {
			clicarBotaoPorTexto(" //span[contains(.,'Select from Employeer')]");
			clicarBotaoPorTexto(" //div[@id='field_salesRepEmployeeNumber_chosen']/div/ul/li[8]");
		}
		catch(Exception e) {
	  
		}
	}
	
	public void setCredit(String nome) {
		escrever("field-creditLimit", nome);
	}
	
	public void salvar() {
		clicarBotao("form-button-save");
	}
	
	public String obterMensagem(){
		return obterTexto(By.xpath(" //p[contains(.,'Your data has been successfully stored into the database. Edit Customer or Go back to list')]"));
	}
	
	public void voltar() {
		clicarBotaoPorTexto("//a[contains(text(),'Go back to list')]");
	}
	
}
