package com.lao.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:/FeatureFiles",
		glue="com.lao.step_definition",
		dryRun=true,
		monochrome=true,
		plugin= {"rerun:target/failed_scenarios.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner {
	
//	pretty --> Reports in console
//	Monochrome --> Human readable format
//  Usage --> Duration for each steps ---> Performance --> reports in console
//	html:target/cucumber-reports/report.html--> plugin ---> HTML Report
//	json:target/cucumber-reports/report.json--> plugin ---> JSON Report
//	junit:target/cucumber-reports/report.xml--> plugin ---> XML Report

}
