package ru.netology.postman;

import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void shouldPostDataAndCheckResponse() {
        String testData = "Hello from Postman Echo!";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(testData)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(testData));
    }
}