package org.reqres.tests.positive;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.reqres.ReqResBase;
import org.reqres.utils.ApiConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllUsersTest extends ReqResBase {

    @Test
    public static void getAllUsers() {
        Response response = RestAssured.
                when().get("/api/users?page=2");
        response.then().statusCode(ApiConstants.STATUS_200).log().all();
        boolean isContentTypeJson = response.headers().get("Content-Type")
                .getValue().equalsIgnoreCase("application/json; charset=utf-8");
        Assert.assertTrue(isContentTypeJson);
    }
}
