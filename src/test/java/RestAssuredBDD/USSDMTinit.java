package RestAssuredBDD;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class USSDMTinit {

    String JsonObject1;
    String JsonObject2;
    ObjectMapper objectMapper;
    JsonNode jsonNode1;
    JsonNode jsonNode2;

    //json request load to te bute array
    public static byte[] req;
    public static byte[] obj2;

    static {
        try {
            req = Files.readAllBytes(Paths.get("src\\main\\java\\Requests\\USSDMTinit.json"));
            obj2 = Files.readAllBytes(Paths.get("src\\main\\java\\Responses\\USSDMTInit.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //then byte array load to the string array
    public static String request = new String(req);


    @BeforeMethod
    public void beforeMethodAPI() throws IOException {
        RestAssured.baseURI="http://35.207.4.105:9090/ussd/outbound/tel:+94777777745";


    }

    @Test
    public void USSDInit(){
        Response response = given()
                .contentType("application/json")
                .body(request)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200).extract().response();

        String responseJson = response.asString();
        Assert.assertEquals(responseJson.contains("mtinit"),true);


        System.out.println("Request: "+request);



    }

}
