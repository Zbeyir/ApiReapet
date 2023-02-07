package ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class Api_10_SpartanDELETERequest {

    @BeforeClass
    public void setUp() {
        baseURI = "http://54.236.150.168:8000";

    }

    @Test
    public void test1() {

        given().pathParam("id", 732)
                .when().delete("/api/spartans/{id}")
                .then().statusCode(204);

        // verify part
        given().pathParam("id", 732)
                .when().delete("/api/spartans/{id}")
                .then().statusCode(404);


    }


}
