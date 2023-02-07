package ApiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Api_11_Bookit_Auth {

    /*
    normalde --> Bearer  ---> bunu da yazmak lazim ama ben bunsuz da sonuc aldim
     */
    String accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxODE2IiwiYXVkIjoidGVhY2hlciJ9.9O2Q3Zo9jVq32OmBlAx5X26f0TtdIytJHB9LFlfQJGI";

    //     String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxODE2IiwiYXVkIjoidGVhY2hlciJ9.9O2Q3Zo9jVq32OmBlAx5X26f0TtdIytJHB9LFlfQJGI";

    @BeforeClass
    public void setUp() {
        baseURI = "https://cybertek-reservation-api-qa3.herokuapp.com";

    }

    @Test
    public void test1() {

        Response response = given().headers("Authorization", accessToken)
                .when().get("/api/campuses");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();

    }


}
