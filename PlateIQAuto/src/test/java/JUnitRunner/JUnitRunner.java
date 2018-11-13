package JUnitRunner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		dryRun=false,
		strict=true,
		monochrome=false,
		features= {"resources/Features"},
		glue = {"StepDefinitions"},
		plugin= {
				"html:target/site/cucumber-html",
				"json:target/cucumber1.json"},
		tags= {" @Invoicescenario"}
		)

public class JUnitRunner {

}
