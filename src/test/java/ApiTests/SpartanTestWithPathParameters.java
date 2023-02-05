package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpartanTestWithPathParameters {

    /**
     * Burada' ki -->  .baseURI ==> sistemden gelme biz yazmadik yani
     * SpartanTests ---> class' da biz kendimiz hatirlar isen String ile yapmistik
     */
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://54.236.150.168:8000";
    }


    /*
    Given accept type Json
    And Id parameter value 18
    When user sends GET request to /api/spartans/{id}
    Then response status code must be 200
    And response Content-Type: application/json
    And "Allen" should be response payload
     */
    @Test
    public void pathTest1() {

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .and().pathParam("id", "18")
                .when().get("/api/spartans/{id}");


        // verify status code
        Assert.assertEquals(response.statusCode(), 200);

        // verify Content-Type
        Assert.assertEquals(response.contentType(), "application/json");

        // verify "Allen" exist
        Assert.assertTrue(response.body().asString().contains("Allen"));

        response.body().prettyPrint();

    }

     /*
    Given accept type Json
    And Id parameter value 500
    When user sends GET request to /api/spartans/{id}
    Then response status code must be 404
    And response Content-Type: application/json
    And "Not Found" should be response payload
     */

    @Test
    public void negativePathTest() {

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .and().pathParam("id", 500)
                .when().get("/api/spartans/{id}");

        // verify status code
        Assert.assertEquals(response.statusCode(), 404);

        // verify Content-Type
        Assert.assertEquals(response.contentType(), "application/json");

        // verify "Allen" exist
        Assert.assertTrue(response.body().asString().contains("Not Found"));

        response.body().prettyPrint();


    }

}
