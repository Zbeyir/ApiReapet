package ApiTests;

import io.restassured.http.ContentType;

/*
// artik burada statik improt ve sonunu yildiz yaptik,
 tekrar tekrar assagida teste  Matchers yazmak zorunda kalmadik

 */
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class Api_6_SpartanTestWithHamcrest_2 {

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
    public void test2() {

        // request
        given().contentType(ContentType.JSON)
                .pathParam("id", 16)
                .when().get("/api/spartans/{id}")
                // response
                .then().statusCode(200)
                .and().assertThat().contentType("application/json")
                // hamcrest.Matchers.*   start
                .and().assertThat().body("id", equalTo(16),
                        "name", equalTo("Sinclair"),
                        "gender", equalTo("Male"),
                        "phone", equalTo(9714460354l));

    }

}
