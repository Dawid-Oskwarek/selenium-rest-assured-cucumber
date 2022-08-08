package com;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class ApiUtil {
    
    private static Response response;

    public static void runPOST(String url, String requestBody) throws Exception {

        response = RestAssured.given()
        .relaxedHTTPSValidation()
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .post(url);
        
        System.out.println("STATUS: " + response.statusCode());
    }

    public static Response getResponse() {
        System.out.println(response.asString());
        return response;
    }
}
