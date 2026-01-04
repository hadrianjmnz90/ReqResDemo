package org.reqres;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class ReqResBase {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification requestSpec = given()
                .header("x-api-key", "reqres-free-v1");
        RestAssured.requestSpecification = requestSpec;
    }
}
