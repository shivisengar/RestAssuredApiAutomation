package com.api.utils;

import com.api.utils.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecUtil {

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("base.url"))
                .setContentType(ContentType.JSON)
               .addHeader("User-Agent", "Mozilla/5.0")
                .log(LogDetail.ALL)
                .build();
    }
}
