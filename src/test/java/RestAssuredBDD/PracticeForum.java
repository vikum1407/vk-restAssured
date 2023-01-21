package RestAssuredBDD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;

import static io.restassured.RestAssured.given;

public class PracticeForum {

    public static HashMap params = new HashMap();

    @BeforeMethod
    public void beforeMethod(){
        RestAssured.baseURI = "http://35.207.4.105:9090/smsmessaging/outbound/8080/requests";
        params.put("senderAddress","tel:+8080");
        params.put("senderName","BBB8080");
        params.put("clientCorrelator","desw");

    }

    @Test
    public void POSTMethod(){
        Response response =
        given()
          .contentType("application/json")
          .body(params)
             .when()
                .post()
             .then()
                 .statusCode(201)
                 .log().all().extract().response();

        //response is in json format. need to convert it into the string format
        String responseString = response.asString();
        Assert.assertEquals(responseString.contains("94770000976"),true);
    }
}
