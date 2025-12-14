package api;

import base.BaseTest;
import data.TestData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateAdminAPITest extends BaseTest {

    @Test
    public void createAdmin() {

        given()
                .baseUri("https://api-smartsaving-bete.dafagate.com/api/v1")
                .contentType("application/json")
                .body("""
                {
                  "name": "ادمن تجريبي",
                  "phone": "%s",
                  "password": "P@ssw0rd",
                  "password_confirmation":"P@ssw0rd",
                  "country_id":"1",
                  "accepted_terms":"1",
                  "type":"regular"
                 }
            """.formatted( TestData.mobile))
                .when()
                .post("/register")
                .then()
                .statusCode(200);
    }
}
