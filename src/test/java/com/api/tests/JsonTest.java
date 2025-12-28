package com.api.tests;

import com.api.models.UserPayload;
import com.api.models.UserResponse;
import com.api.services.UserServices;
import com.api.utils.ExcelUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class JsonTest {


    @Test
    public void createAndGetUser() {

        String excelPath = getClass()
                .getClassLoader()
                .getResource("testData/UserData.xlsx")
                .getPath();

        Map<String, String> excelData =
                ExcelUtils.getRowData(excelPath, "CreateUser", 1);

        String name = excelData.get("name");
        String job = excelData.get("job");

        UserPayload payload = new UserPayload(name, job);

        // 5. POST
        Response postRes = UserServices.createUser(payload);
        Assert.assertEquals(postRes.statusCode(), 201);

        String userId = postRes.jsonPath().getString("id");
        Assert.assertNotNull(userId);

        // 6. GET requ
        Response getRes = UserServices.getUser("1");
        Assert.assertEquals(getRes.statusCode(), 200);
    }
    }


