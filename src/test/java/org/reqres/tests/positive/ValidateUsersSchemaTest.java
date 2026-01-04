package org.reqres.tests.positive;

import io.restassured.RestAssured;
import org.reqres.ReqResBase;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class ValidateUsersSchemaTest extends ReqResBase {

    @Test
    public void validateUsersSchema() {
        RestAssured
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .assertThat()
                .statusCode(200)
                .body(  matchesJsonSchemaInClasspath ("json-schema-users.json"));
    }
}
