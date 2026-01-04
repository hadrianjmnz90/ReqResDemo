package org.reqres.tests.negative;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.reqres.ReqResBase;
import org.reqres.utils.ApiConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class UserNotFoundTest extends ReqResBase {

    @Test
    public static void validateUserPostNotFound() {
        Response response = RestAssured.
                when().get("/posts/9999");
        System.out.println(response.body().toString());
        response.then()
                .statusCode(anyOf(is(401), is(403), is(404)))
                .log().all();

        boolean isContentTypeJson = response.headers().get("Content-Type").getValue()
                .equalsIgnoreCase("application/json; charset=utf-8");
        Assert.assertTrue(isContentTypeJson);

        Assert.assertTrue(response.getBody().asString().trim().equals("{}") ||
                        response.getBody().asString().trim().isEmpty(),
                "Expected empty or {} body");

        Assert.assertTrue ( response.timeIn(TimeUnit.MILLISECONDS)
                < ApiConstants.ACCEPTABLE_RESPONSE_TIME, "Response time exceeded the threshold");
    }
}
