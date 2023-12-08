package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import driver.Driver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature",
		tags = "@buscarCep",
		glue = "steps",
		dryRun = false,
		monochrome = false,
		plugin = {"pretty", "html:target/cucumber-report.html "},
		snippets = SnippetType.CAMELCASE
		
		)


public class Executa {

	

	
}
