package com.api.support;

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

        System.out.println("\n" + "Response Body: ");
        System.out.println("STATUS: " + response.statusCode());
        System.out.println(response.asString());
    }

    public static Response getResponse() {
        return response;
    }
}
