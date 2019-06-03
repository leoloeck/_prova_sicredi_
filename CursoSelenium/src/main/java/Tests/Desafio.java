package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.DriverFactory;
import pages.AddCustomerPage;
import pages.CustomersPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Desafio{
	
	static AddCustomerPage addCustomerPage = new AddCustomerPage();
	static CustomersPage customersPage = new CustomersPage();
	static DriverFactory driverFactory = new DriverFactory();
	
	@Test
	public void test1_InserirCustomer(){
		//customersPage.acessar();
		customersPage.selectVersion("Bootstrap V4 Theme");
		customersPage.adicionar();
		addCustomerPage.setNome("Teste Sicredi");
		addCustomerPage.setLastName("Teste");
		addCustomerPage.setFirstName("Leonardo");
		addCustomerPage.setFone("51 9999-9999");
		addCustomerPage.setAdress("Av Assis Brasil, 3970");
		addCustomerPage.setAdress2("field-addressLine2");
		addCustomerPage.setCity("Porto Alegre");
		addCustomerPage.setState("RS");
		addCustomerPage.setPostal("91000-000");
		addCustomerPage.setCountry("Brasil");
		addCustomerPage.setEmployeer();
		addCustomerPage.setCredit("200");
		addCustomerPage.salvar();
		String msg = addCustomerPage.obterMensagem();
		
		assertEquals(msg, "Your data has been successfully stored into the database. Edit Customer or Go back to list");

	}
	
	@Test
	public void test2_DeleteCustomer(){
		addCustomerPage.voltar();
		customersPage.pesquisar("Teste Sicredi");
		customersPage.espera();
		customersPage.seleciona();
		customersPage.deletar();
		String txt = customersPage.obterMensagem();
		
		System.out.println(txt);
		assertEquals(txt, "Your data has been successfully deleted from the database.");
		addCustomerPage.fim();
	}
	
}
