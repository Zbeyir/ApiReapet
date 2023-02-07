package ApiTests;

import com.beust.ah.A;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Api_9_SpartanPOSTRequest {

    @BeforeClass
    public void setUp() {
        baseURI = "http://54.236.150.168:8000";

    }

    /*
    Given Accept Type and Content Type is Json
    And Request json body is:
    {
        "name": "Abuzer",
        "gender": "Male",
        "phone": 1234567890
    }
    When user sends POST request to "/api/spartans"
    Then status code must be 201
    And Content Type should be application/json
    And json payload/response should contain:
            "A Spartan is Born!"
    And same data what is posted
     */
    @Test
    public void PostWithString() {

        // sending json body as String
        Response response = given().contentType(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and().body("{\n" +
                        "  \"gender\": \"Male\",\n" +
                        "  \"name\": \"Abuzer\",\n" +
                        "  \"phone\": 1234567890\n" +
                        "}")
                .when().post("/api/spartans");

        response.prettyPrint();

        // validations
        // verify status code 201
        assertEquals(response.statusCode(), 201);

        assertEquals(response.contentType(), "application/json");

        // verify success massage
        assertEquals(response.path("success"), "A Spartan is Born!");

        // verify request body
        JsonPath json = response.jsonPath();

        assertEquals(json.getString("data.name"), "Abuzer");
        assertEquals(json.getString("data.gender"), "Male");
        assertEquals(json.getLong("data.phone"), 1234567890l);


    }

    @Test
    public void PostMethodWithMap() {
        // create map to be used as body for POST request
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("name", "MikailMap");
        requestMap.put("gender", "Male");
        requestMap.put("phone", 1234567890l);

        Response response = given().contentType(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and().body(requestMap)
                .when().post("/api/spartans");

        response.prettyPrint();

        assertEquals(response.statusCode(), 201);

    }

    @Test
    public void POSTWithPojo() {
        // create Spartan object and used as a body for post request

        Api_8_Spartan spartan = new Api_8_Spartan();
        spartan.setName("BijiPojo");
        spartan.setGender("Male");
        spartan.setPhone(1234567890l);

        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and().body(spartan)
                .when().post("/api/spartans");


        assertEquals(response.statusCode(), 201);
        assertEquals(response.contentType(), "application/json");

        response.prettyPrint();

        //=====================GET REQUEST=============

        Response response2 = given().accept(ContentType.JSON)
                .pathParam("id", 732)
                .when().get("/api/spartans/{id}");

        Api_8_Spartan spartanResponse = response2.body().as(Api_8_Spartan.class);

        System.out.println(spartanResponse.toString());

    }
}
