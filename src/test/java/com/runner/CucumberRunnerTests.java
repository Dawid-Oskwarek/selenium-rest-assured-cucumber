package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "api", features = "src/test/resources/features/example.feature", glue = "com.example.cucumber_testng.definitions")


public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    
}
