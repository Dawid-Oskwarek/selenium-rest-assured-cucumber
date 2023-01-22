package com.api.support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    private final RequestSpecification requestSpec;

    public ApiClient(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        requestSpec = RestAssured.given();
    }

    public Response get(String path) {
        Response response = requestSpec.get(path);
        logResponse(response);
        return response;
    }

    public Response post(String path, String body) {
        Response response = requestSpec.body(body).post(path);
        logResponse(response);
        return response;
    }

    public Response put(String path, String body) {
        Response response = requestSpec.body(body).put(path);
        logResponse(response);
        return response;
    }

    public Response delete(String path) {
        Response response = requestSpec.delete(path);
        logResponse(response);
        return response;
    }

    public ApiClient setHeader(String key, String value) {
        requestSpec.header(key, value);
        return this;
    }

    public ApiClient setBearerAuth(String token) {
        requestSpec.header("Authorization", "Bearer " + token);
        return this;
    }

    public ApiClient setBasicAuth(String username, String password) {
        requestSpec.auth().basic(username, password);
        return this;
    }

    public ApiClient setQueryParam(String key, String value) {
        requestSpec.queryParam(key, value);
        return this;
    }

    public ApiClient setFormParam(String key, String value) {
        requestSpec.formParam(key, value);
        return this;
    }

    public void logResponse(Response response) {
        System.out.println("Response: ");
        System.out.println("STATUS: " + response.statusCode());
        System.out.println(response.asString());
    }
}
