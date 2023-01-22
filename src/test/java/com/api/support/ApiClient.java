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
        return requestSpec.get(path);
    }

    public Response post(String path, String body) {
        return requestSpec.body(body).post(path);
    }

    public Response put(String path, String body) {
        return requestSpec.body(body).put(path);
    }

    public Response delete(String path) {
        return requestSpec.delete(path);
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
}
