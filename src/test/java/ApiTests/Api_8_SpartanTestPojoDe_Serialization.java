package ApiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Api_8_SpartanTestPojoDe_Serialization {

    @BeforeClass
    public void setUp() {
        baseURI = "http://54.236.150.168:8000";

    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 16)
                .when().get("/api/spartans/{id}");


        // Gson --> de-serialization
        // how to convert json response to our spartan class
        Api_8_Spartan spartan1 = response.body().as(Api_8_Spartan.class);

        System.out.println(spartan1.toString());

        assertEquals(spartan1.getId(),16);
        assertEquals(spartan1.getName(),"Sinclair");
        assertEquals(spartan1.getGender(),"Male");
        assertEquals(spartan1.getPhone(),9714460354l);


    }

}
