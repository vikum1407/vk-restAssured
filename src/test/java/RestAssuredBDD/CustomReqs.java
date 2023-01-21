package RestAssuredBDD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CustomReqs {

    public static HashMap params = new HashMap();

    @BeforeMethod
    public void beforeMethod(){
        RestAssured.baseURI="http://35.207.4.105:9090/smsmessaging/outbound/8080/requests";
        //RestAssured.basePath="/queries/location?address=tel:+94777777771&requestedAccuracy=1000";

        params.put("senderAddress","tel:+8080");
        params.put("senderName","BBB8080");
        params.put("clientCorrelator","desw");


    }

    //@Test
    public void GETMethodReq(){
        given()
             .contentType("application/json")
        .when()
             .get()
        .then()
                .log().all()
                .statusCode(200)
                .body("terminalLocationList.terminalLocation.locationRetrievalStatus", Matchers.equalTo("Retrieved"));

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
                .statusCode(201).log().all().extract().response();

        //response having json format. so need to convert it into string format
        String jsonResponse = response.asString();
        Assert.assertEquals(jsonResponse.contains("94770000976"),true);
    }
}
