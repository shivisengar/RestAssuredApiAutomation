package com.api.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DummyTest {
    @Test
    public void directTest() {

        given()
                .baseUri("https://reqres.in")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .contentType(ContentType.JSON)
                .body("{\"name\":\"shivani\",\"job\":\"QA\"}")
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .statusCode(201);
    }
}
