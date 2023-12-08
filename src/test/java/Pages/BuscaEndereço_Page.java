package Pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import driver.Driver;
import metodos.Metodos;
import runner.Executa;

public class BuscaEndereço_Page extends Driver {

	Metodos metodo = new Metodos();
	Executa executa = new Executa();

	// Massa de dados
	private String msg = "Não há dados a serem exibidos"; // armazenar mensagem esperada
	private String massaCEP = "02842-120"; // Armazenando CEP
	private String enderecoCompleto = "Rua Barroco,Jardim do Tiro,São Paulo/SP";
	// Elementos
	private By msgErro = By.xpath("//*[@id='mensagem-resultado']");
	By enderecoLogradouro = By.xpath("//*[@id='resultado-DNEC']/tbody/tr/td[1]");
	By bairroDistrito = By.xpath("//*[@id='resultado-DNEC']/tbody/tr/td[2]");
	By localidadeUF = By.xpath("//*[@id='resultado-DNEC']/tbody/tr/td[3]");
	private By Cep = By.xpath("//*[@id='resultado-DNEC']/tbody/tr/td[4]");
	By cookie = By.xpath("//*[@id='btnCookie']");
	By buscarEndereco = By.xpath("//input[@name='relaxation']");
	By btnBusca = By.xpath("//*[@class='ic-busca-out']");

	public void pesquisarCEP(String Endereco) throws InterruptedException {

		metodo.await(3000);
		metodo.Validarcookie(3, this.cookie); // Validar Cookie
		metodo.SendKey(this.buscarEndereco, Endereco);// Pesquisar cep armazenado na classe home
		metodo.submit(this.buscarEndereco); // Pressionar Enter para pesquisar
		metodo.newTab(1);// Alternar para outra guia

	}

	public void validarEndereco(String EnderecoEsperado) throws InterruptedException {
		metodo.await(3000);
		// capturar Endereço completo
		String enderecoLogradouro = driver.findElement(this.enderecoLogradouro).getText(); 
		// Rua/Logradouro
		String bairroDistritoCapturado = driver.findElement(this.bairroDistrito).getText();
		// Bairro/Distrito
		String LocalidadeUF = driver.findElement(this.localidadeUF).getText();
		String enderecoCapturado = (enderecoLogradouro+","+bairroDistritoCapturado+","+LocalidadeUF);
		assertEquals(EnderecoEsperado, enderecoCapturado);

	}

	public void validarCEP(String CEPEsperado) throws InterruptedException {
		metodo.await(2000);
		String cepCapturado = driver.findElement(this.Cep).getText();// capturar o cep para validar se corresponde ao
		// cep pesquisado
		assertEquals(CEPEsperado, cepCapturado);
	}
		public void validarMsgErro(String msgEsperada) throws InterruptedException {
			metodo.await(2000);
			String msgCapturada = driver.findElement(this.msgErro).getText();
			assertEquals(msgEsperada, msgCapturada);
			
		}

	public String getMsg() {
		return msg;
	}

	public String getMassaCEP() {
		return massaCEP;
	}

	public By getCep() {
		return Cep;
	}

	public By getMsgErro() {
		return msgErro;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

}
