package com.automation.e2eTests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/spec/features"},
		plugin = {"pretty","html:target/report/cucumber-report.html","json:target/report/cucumber.json"},
		//glue = {"/selenuim-cucumber/src/test/java/com/automation/e2eTests/stepDefinitions"},
		tags = ("@Product"),
		monochrome = true,
		snippets = CAMELCASE		
		)


public class RunWebSuiteTest {
} 
