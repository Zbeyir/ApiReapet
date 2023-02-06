package ApiTests;

import static io.restassured.RestAssured.*;

import static org.testng.Assert.*;

import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Api_6_SpartanTestWithHamcrest {

    @BeforeClass
    public void setUp() {
        baseURI = "http://54.236.150.168:8000";

    }

    /*
    Given accept type Json
     And path param spartan id 16
     When user sends GET request to "/api/spartans/{id}"
    Then response status code must be 200
    And response Content-Type: application/json
    And response payload values match the following
   "id": 16,
    "name": "Sinclair",
    "gender": "Male",
    "phone": 9714460354
     */


    @Test
    public void test1() {

        // request
        given().contentType(ContentType.JSON)
                .pathParam("id", 16)
                .when().get("/api/spartans/{id}")
                // response
                .then().statusCode(200)
                .and().assertThat().contentType("application/json");

    }


    @Test
    public void test2() {

        // request
        given().contentType(ContentType.JSON)
                .pathParam("id", 16)
                .when().get("/api/spartans/{id}")
                // response
                .then().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", Matchers.equalTo(16),
                        "name", Matchers.equalTo("Sinclair"),
                        "gender", Matchers.equalTo("Male"),
                        "phone", Matchers.equalTo(9714460354l));

    }

}
