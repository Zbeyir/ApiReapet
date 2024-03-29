package ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Api_4_SpartanTestWithPathMethod {

    @BeforeClass
    public void setUp() {
        baseURI = "http://54.236.150.168:8000";

    }

    /*
     Given accept type Json
     And Id parameter value 10
     When user sends GET request to "/api/spartans/{id}"
    Then response status code must be 200
    And response Content-Type: application/json
    And response payload values match the following
     id is 10,
    "name is Lorenza",
    "gender is Female",
    "phone is 3312820936

     */

    @Test
    public void test1() {

        Response response = given().contentType(ContentType.JSON)
                .and().pathParam("id", 10)
                .when().get("/api/spartans/{id}");

        // verify status code
        assertEquals(response.statusCode(), 200);

        // verify Content-Type
        assertEquals(response.contentType(), "application/json");

        // printing values of Json keys
        System.out.println("id: " + response.body().path("id").toString());
        System.out.println("name: " + response.body().path("name").toString());
        System.out.println("gender: " + response.path("gender").toString());
        System.out.println("phone: " + response.path("phone").toString());


        int id = response.path("id");
        String name = response.body().path("name");
        String gender = response.body().path("gender");
        long phone = response.path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        assertEquals(id, 10);
        assertEquals(name, "Lorenza");
        assertEquals(gender, "Female");
        assertEquals(phone, 3312820936l);

    }

    @Test
    public void test2() {

        /*
        burada sadec kisa bir query yazdik cünkü;
        ---> diger seylerle ilgilenmedigimiz icin bu teste
         */

        Response response = get("/api/spartans");

        // extract first id
        int firstId = response.path("id[0]"); // because index number start 0
        System.out.println("firstId = " + firstId);

        // extract first firstname
        String first1stName = response.path("name[0]");
        System.out.println("first1stName = " + first1stName);

        // extract second firstname
        String second1stName = response.path("name[1]");
        System.out.println("second1stName = " + second1stName);

        // get the last firstname
        String last1stName = response.path("name[-1]");
        System.out.println("last1stName = " + last1stName);

        // get the last firstname --> buda sondan bir önceki
        String last2stName = response.path("name[-2]");
        System.out.println("last2stName = " + last2stName);

        // extract all firstname and print them
        List<String> names = response.path("name");
        System.out.println(names);
        System.out.println("names = " + names.size());


        List<Object> phoneNumbers = response.path("phone");

        for (Object phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }


    }
}
