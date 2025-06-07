package org.reqres.tests;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.reqres.ReqResBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getAllUsersTest extends ReqResBase {

    @Test
    public static void getAllUsers() {
        Response response = RestAssured.
                when().get("/api/users?page=2");
        response.then().statusCode(200).log().all();

        boolean isContentTypeJson = response.headers().get("Content-Type").getValue().equalsIgnoreCase("application/json; charset=utf-8");
        Assert.assertTrue(isContentTypeJson);
    }

}
