package steps;

import org.openqa.selenium.chrome.ChromeDriver;

import Pages.BuscaEndereço_Page;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends Driver {

	BuscaEndereço_Page page = new BuscaEndereço_Page();

	@Before
	public void abrirNavegador() {
		try {

			String ambiente = "https://www.correios.com.br/";
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(ambiente);

		} catch (Exception e) {
			System.err.println("-------Erro ao abrir navegador-----------------" + e.getClass() + e.getMessage());

		}
	}

	@After
	public void fecharNavegador() {
		driver.quit();

	}

	@When("pesquisar um Cep válido")
	public void pesquisarUmCepVálido() throws InterruptedException {
		page.pesquisarCEP(page.getMassaCEP());

	}

	@Then("validar se o endereço corresponde ao Cep")
	public void validarSeOEndereçoCorrespondeAoCep() throws InterruptedException {
		page.validarEndereco(page.getEnderecoCompleto());

	}

	@When("pesquisar um endereco valido")
	public void pesquisarUmEnderecoValido() throws InterruptedException {
		page.pesquisarCEP(page.getEnderecoCompleto());

	}

	@Then("validar se o Cep corresponde ao endereco")
	public void validarSeOCepCorrespondeAoEndereco() throws InterruptedException {
		page.validarCEP(page.getMassaCEP());

	}
	
	@Given("pesquisar um CEP em branco")
	public void pesquisarUmCEPEmBranco() throws InterruptedException {
		page.pesquisarCEP(" ");

	}

	@When("visualizo mensagem de erro")
	public void visualizoMensagemDeErro() throws InterruptedException {
		page.validarMsgErro(page.getMsg());

	}

	

}
