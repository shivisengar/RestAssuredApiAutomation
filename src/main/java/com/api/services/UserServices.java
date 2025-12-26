package com.api.services;

import com.api.endpoints.Routes;
import com.api.models.UserPayload;
import com.api.utils.RequestSpecUtil;
import com.api.utils.config.ConfigReader;
import io.restassured.response.Response;
import com.api.models.UserPayload;


import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class UserServices {


    public static Response createUser(UserPayload payload) {
        return given()
                .spec(RequestSpecUtil.requestSpec())
                .body(payload)
//                .log().all()
                .when()
          .post(Routes.CREATE_USER).
        then()
                .log().all()
                .extract()
                .response();
//                .post("/users");
    }
    public static Response getUser(String userId) {
        return given()
                .spec(RequestSpecUtil.requestSpec())
              .pathParam("id", userId)
                .log().all()
                .when()
//                .get(ConfigReader.get("users.endpoint") + "/{id}");
                .get(Routes.GET_USER)
          .then()
                .log().all()
                .extract()
                .response();
    }
}
