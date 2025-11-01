package RestTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

//TODO: add location to request
//TODO: Validate that street number and name are not null for 1st person generated

public class RestTests {

    @Test
    public void restTests() {
        ValidatableResponse firstResponse = RestAssured.given()
                .queryParam("inc", "gender,name,nat,location")
                .queryParam("results", "10")
                .queryParam("noinfo")
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("results[0].location.street.number", Matchers.notNullValue())
                .body("results[0].location.street.name", Matchers.notNullValue());
                 firstResponse.extract().response().prettyPrint();

    }
}
