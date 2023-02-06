package ApiTests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static org.testng.Assert.*;


public class Api_5_SpartanTestWithJsonPath {

    @BeforeClass
    public void setUp() {
        baseURI = "http://54.236.150.168:8000";

    }

    /*
    Given accept type Json
     And path param spartan id 14
     When user sends GET request to "/api/spartans/{id}"
    Then response status code must be 200
    And response Content-Type: application/json
    And response payload values match the following
    "id": 14,
    "name": "Grenville",
    "gender": "Male",
    "phone": 1065669615
     */

    @Test
    public void test1() {

        Response response = given().contentType(ContentType.JSON)
                .pathParam("id", 14)
                .when().get("/api/spartans/{id}");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json");

        // how read value with path() method
        int id = response.path("id");
        System.out.println("id = " + id);

        // how read value with JsonPath
        JsonPath jsonData = response.jsonPath();

        int id1 = jsonData.get("id");
        String name = jsonData.getString("name");
        String gender = jsonData.getString("gender");
        long phone = jsonData.getLong("phone");

        System.out.println("id1 = " + id1);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        /*
        Bu sekilde JsonPath() olarak aldigimiz da bir sürü varyant var
         */

        //  verify Json payload with JsonPath
        assertEquals(id1,14); // ilk önce hata aldim cümkü bunu "" tirnak isareti icinde yazmistim
        assertEquals(name,"Grenville");
        assertEquals(gender,"Male");
        assertEquals(phone,1065669615l);  // ilk önce hata aldim cümkü bunu "" tirnak isareti icinde yazmistim


    }

}
