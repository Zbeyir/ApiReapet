package ApiTests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Api_7_SpartanJsonToCollections {

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
   "id": 16,
    "name": "Sinclair",
    "gender": "Male",
    "phone": 9714460354
     */
    @Test
    public void test1() {
        Response response = given().contentType(ContentType.JSON)
                .pathParam("id", 16)
                .when().get("/api/spartans/{id}");

        // convert Json response to Java Collections (Map)
        Map<String, Object> spartanMap = response.body().as(Map.class);

        System.out.println(spartanMap.get("id"));
        System.out.println(spartanMap.get("name"));
        System.out.println(spartanMap.get("gender"));
        System.out.println(spartanMap.get("phone"));

        // assertEquals(spartanMap.get("id"),16);
        assertEquals(spartanMap.get("name"), "Sinclair");
        assertEquals(spartanMap.get("gender"), "Male");
        // assertEquals(spartanMap.get("phone"),9714460354l);

    }

    @Test
    public void test2() {

        Response response = given().contentType(ContentType.JSON)
                .when().get("/api/spartans");

        // convert full Json body to list of maps
        List<Map<String, Object>> listOfSpartans = response.body().as(List.class);

        // print all data od first spartan
        System.out.println(listOfSpartans.get(0));

        Map<String, Object> firstSpartan = listOfSpartans.get(0);

        System.out.println(firstSpartan.get("name"));

        int counter = 1;
        for (Map<String, Object> map : listOfSpartans) {

            System.out.println(counter + "-spartan " + map);
            counter++;
        }


    }
}
