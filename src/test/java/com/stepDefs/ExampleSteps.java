package com.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.Assert;
import com.ApiUtil;
import io.cucumber.java.en.And;


public class ExampleSteps {

    private String body;

    @Given("a json request is set")
    public void jsonRequestIsSet() {

    JSONObject json = new JSONObject();
    json.put("name", "morpheus");
    json.put("job", "leader");

    this.body = json.toString();
    System.out.println("\n" + "Request Body: " + "\n" + this.body);

    }

    @When("a POST request is sent")
    public void postRequest() throws Exception {

        String url = "https://reqres.in/api/users";
        ApiUtil.runPOST(url, this.body);
 
    }

    @Then("the status code is {int}")
    public void verifyStatusCode(int expectedStatusCode) {

        int statusCode = ApiUtil.getResponse().statusCode();
        Assert.assertEquals(statusCode, expectedStatusCode);
    }

    @And("the response is valid")
    public void responseIsValid() {

        JSONObject obj = new JSONObject(ApiUtil.getResponse().asString());
        String name = obj.getString("name");
        Assert.assertEquals(name, "morpheus");

    }
}
