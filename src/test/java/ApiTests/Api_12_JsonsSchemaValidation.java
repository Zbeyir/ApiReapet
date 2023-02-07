package ApiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import static io.restassured.module.jsv.JsonSchemaValidator.*; // burayi import ettik

public class Api_12_JsonsSchemaValidation {

    @BeforeClass
    public void setUp() {
        baseURI = "http://54.236.150.168:8000";

    }

    @Test
    public void test1() {

        given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat()
                .body(matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));


    }


}
