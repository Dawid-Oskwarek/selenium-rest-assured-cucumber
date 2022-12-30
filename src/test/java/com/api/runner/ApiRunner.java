package com.api.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@api", features = "src/test/resources/api/features", glue = "com.api.stepDefs" )


public class ApiRunner extends AbstractTestNGCucumberTests {
    
}
