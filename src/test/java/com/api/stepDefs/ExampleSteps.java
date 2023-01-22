package com.api.stepDefs;

import com.api.support.ApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import com.api.support.ApiUtil;
import io.cucumber.java.en.And;


public class ExampleSteps {

    private String body;
    private Response response;


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
    @When("a POST request is sent using an API Client")
    public void postRequestApiClient() {

        ApiClient client = new ApiClient("https://reqres.in/api/users");
        this.response = client
                .setHeader("Content-Type", "application/json")
                .post("/posts/1", this.body);

    }
    @Then("the status code is {int}")
    public void verifyStatusCode(int expectedStatusCode) {

        int statusCode = ApiUtil.getResponse().statusCode();
        Assert.assertEquals(statusCode, expectedStatusCode);

    }

    @Then("the status code for API Client response is {int}")
    public void verifyStatusCodeApiClient(int expectedStatusCode) {

        Assert.assertEquals(this.response.statusCode(), expectedStatusCode);

    }

    @And("the response is valid")
    public void responseIsValid() {

        JSONObject obj = new JSONObject(ApiUtil.getResponse().asString());
        String name = obj.getString("name");
        Assert.assertEquals(name, "morpheus");

    }

    @And("the response from API Client is valid")
    public void responseIsValidApiClient() {

        JSONObject obj = new JSONObject(this.response.asString());
        String name = obj.getString("name");
        Assert.assertEquals(name, "morpheus");

    }
}
