package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "api", features = "src/test/resources/features/example.feature", glue = "com.stepDefs")


public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
    
}
