package metodos;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import driver.Driver;

public class Metodos extends Driver {

	/**
	 * Metodo para escrever no browser
	 * 
	 * @param elemento
	 * @param texto
	 * @author Guilherme
	 */

	public void SendKey(By elemento, String texto) {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.err.println("-------------------------------ERRO AO ESCREVER--------------------" + e.getMessage()
					+ e.getCause());
		}

	}

	/**
	 * Metodo para clicar no browser
	 * 
	 * @param elemento
	 * 
	 * @author Guilherme
	 */

	public void Click(By elemento) {
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.err.println("----------------------------ERRO AO CLICAR------------------------" + e.getMessage()
					+ e.getCause());
		}
	}

	/**
	 * Metodo para pressionar enter no browser
	 * 
	 * @param elemento
	 * 
	 * @author Guilherme
	 */
	public void submit(By elemento) {
		try {
			driver.findElement(elemento).submit();
		} catch (Exception e) {
			System.err.println("----------------------------ERRO AO CLICAR------------------------" + e.getMessage()
					+ e.getCause());
		}
	}

	/**
	 * Metodo para tirar um screenshoot do browser para evidenciar teste
	 * 
	 * @param nomeEvidencia
	 * @author Guilherme
	 */

	public void screenshot(String nomeEvidencia) {
		try {
			TakesScreenshot srcShoot = ((TakesScreenshot) driver);
			File srcFile = srcShoot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./evidencias/" + nomeEvidencia + ".png");
			FileUtils.copyFile(srcFile, destFile);

		} catch (Exception e) {
			System.err.println(
					"-----------------------ERRO AO NA VALIDAÇÃO---------------------" + e.getMessage() + e.getCause());
		}

	}

	/**
	 * Metodo para continuar teste em outra guia do browser
	 * 
	 * @param elemento
	 * @param qtds     tabs
	 * @author Guilherme
	 */

	public void newTab(int tabs) {
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(tabs));

	}

	/**
	 * Metodo criado para interromper o teste por alguns milisegundos
	 * 
	 * @param temp
	 * @author Guilherme
	 */

	public void await(int temp) throws InterruptedException {
		Thread.sleep(temp);
	}

	/**
	 * Metodo para validar cookie na pagina
	 * 
	 * @param elemento
	 * 
	 * @author Guilherme
	 */
	public void Validarcookie(int qtdClicks, By element) {
		try {
			WebElement cookie = driver.findElement(element);
			do {

				Click(element);
				qtdClicks--;
			} while (cookie.isDisplayed() && qtdClicks > 0);
			{

			}
		} catch (Exception e) {
			System.err.println("----------------------ERRO AO NA VALIDAR COOKIE---------------------" + e.getMessage()
					+ e.getCause());
		}
	}
}
