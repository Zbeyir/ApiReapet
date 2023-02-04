package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SpartanTests {

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


}
