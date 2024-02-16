package com.lao.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/failed_scenarios.txt",
		glue="com.lao.step_definition",
		dryRun=false,
		monochrome=true
		
)
public class ReRunner {

}
