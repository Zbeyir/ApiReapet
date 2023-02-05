package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Api_1_SpartanTests {

    String spartanBaseUrl = "http://54.236.150.168:8000";

    @Test
    public void viewSpartanTest1() {

        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");


        // print status code
        System.out.println("response.statusCode() = " + response.statusCode());

        // print body
        System.out.println("response.body().asString() = " + response.body().asString());

        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());


    }

    /*
    When user send Get request to /api/spartans end point
    Then status code must be 200
    And body should contain Allen --> bu Allen herhangi bir isim. yani sen baska ismi de test edebilirsin varmi yok mu diye
     */
    @Test
    public void viewSpartanTest2() {

        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");

        // verify status code 200
        Assert.assertEquals(response.statusCode(), 200);

        // verify body contain Allen
        Assert.assertTrue(response.body().asString().contains("Allen"));

    }

    /*
    Given Accept type is Json
    When user sends Get request to spartanAllUrl
    Then status code must be 200
    Then response body should be Json format
     */
    @Test
    public void viewSpartanTest3() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(spartanBaseUrl + "/api/spartans");

        // verify status code 200
        Assert.assertEquals(response.statusCode(), 200);

        // verify response body Json format
        Assert.assertEquals(response.contentType(),"application/json");

    }

}

// 9. video da kaldik