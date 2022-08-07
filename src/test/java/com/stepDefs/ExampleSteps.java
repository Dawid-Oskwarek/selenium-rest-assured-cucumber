package com.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.Assert;

import com.ApiUtil;

import io.cucumber.java.en.And;


public class ExampleSteps {

    @Given("a json request is set")
    public void jsonRequestIsSet() {

    JSONObject json = new JSONObject();
    json.put("Key", "Value");
    }

    @When("a POST request is sent")
    public void postRequest() {

        //String url = "localhost";

        System.out.println("\n" + "Response Body: " + "\n");
        //ApiUtil.runPOST(url, requestBody);
 
    }

    @Then("the status code is (.*)")
    public void verifyStatusCode(int expectedStatusCode) {

        int statusCode = ApiUtil.getResponse().statusCode();
        Assert.assertEquals(statusCode, expectedStatusCode);
    }

    @And("the response is valid")
    public void responseIsValid() {
 
    }
}
