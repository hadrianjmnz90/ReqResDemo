package org.reqres;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ReqResBase {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }
}
