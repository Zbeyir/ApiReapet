package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Api_3_SpartanTestWithQueryParams {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://54.236.150.168:8000";
    }

    /*
    Given accept type Json
    And query parameter value are:
    gender|Female
    nameContains|e
    When user sends GET request to /api/spartans/search
    Then response status code must be 200
    And response Content-Type: application/json
    And "Female" should be response payload
    And "Jeanelle" should be response payload

     */
    @Test
    public void queryParamTest1() {
        Response response = given().contentType(ContentType.JSON)
                .and().queryParam("gender", "Female")
                .and().queryParam("nameContains", "e")
                .when().get("/api/spartans/search");

        //verify status code
        Assert.assertEquals(response.statusCode(), 200);

        //verify Content-Type
        Assert.assertEquals(response.contentType(), "application/json");

        // verify Female
        Assert.assertTrue(response.body().asString().contains("Female"));

        // verify Male NOT Exist
        Assert.assertFalse(response.body().asString().contains("Male"));

        // verify Jeanelle
        Assert.assertTrue(response.body().asString().contains("Jeanelle"));


    }

    @Test
    public void queryParamTest2() {

        // creating Map for query params
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("gender", "Female");
        paramsMap.put("nameContains", "e");

        // send request
        Response response = given().accept(ContentType.JSON)
                .and().queryParams(paramsMap)
                .when().get("/api/spartans/search");


        //verify status code
        Assert.assertEquals(response.statusCode(), 200);

        //verify Content-Type
        Assert.assertEquals(response.contentType(), "application/json");

        // verify Female
        Assert.assertTrue(response.body().asString().contains("Female"));

        // verify Male NOT Exist
        Assert.assertFalse(response.body().asString().contains("Male"));

        // verify Jeanelle
        Assert.assertTrue(response.body().asString().contains("Jeanelle"));


    }
}
