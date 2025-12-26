package com.api.base;

import com.api.utils.config.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigReader.get("base.url");
    }
}
