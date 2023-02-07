package ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Api_10_SpartanPUTRequest {

    @BeforeClass
    public void setUp() {
        baseURI = "http://54.236.150.168:8000";

    }

    @Test
    public void PUTRequest() {
        // Different ways to send json body
        //-String
        //Using collection(Map)
        //-POJO

        //Using Map
        Map<String, Object> putMap = new HashMap<>();
        putMap.put("name", "AbuzerPUT");
        putMap.put("gender", "Male");
        putMap.put("phone", 1234567890l);

        // we gonna send request body with update value, and content type header
        given().contentType(ContentType.JSON)
                .pathParam("id", 732)
                .and().body(putMap)
                .when().put("/api/spartans/{id}")
                .then().assertThat().statusCode(204);


    }
    @Test
    public void PATCHRequest() {
        // Different ways to send json body
        //-String
        //Using collection(Map)
        //-POJO

        //Using Map
        Map<String, Object> PATCHMap = new HashMap<>();
        PATCHMap.put("name", "AbuzerPatch2");


        // we gonna send request body with update value, and content type header
        given().contentType(ContentType.JSON)
                .pathParam("id", 729)
                .and().body(PATCHMap)
                .when().patch("/api/spartans/{id}")
                .then().assertThat().statusCode(204);


    }

}
