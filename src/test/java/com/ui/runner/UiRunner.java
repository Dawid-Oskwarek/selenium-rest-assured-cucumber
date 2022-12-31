package com.ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@ui", features = "src/test/resources/ui/features", glue = "com.ui.stepDefs" )


public class UiRunner extends AbstractTestNGCucumberTests {
    
}
