package RestAssuredBDD;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ResponseValidation {

    public static byte[] req;

    static {
        try {
            req = Files.readAllBytes(Paths.get("src\\main\\java\\Requests\\USSDMTinit.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String reqString = new String(req);

    @Test(priority = 1)
    public void validateUSSD(){
        given()
            .contentType("application/json")
            .body(reqString)
        .when()
             .post("http://35.207.4.105:9090/ussd/outbound/tel:+94777777745")
        .then()
             .statusCode(200)
             .body("outboundUSSDMessageRequest.keyword", equalTo("123")); //here u can use jsonpath finder extension


    }

    @Test(priority = 2)
    public void validateUSSDWithMultipleItems(){
        given()
                .contentType("application/json")
                .body(reqString)
                //.param("FirstName","vikum")
                .header("Authontication","Bearer ")
        .when()
                .post("http://35.207.4.105:9090/ussd/outbound/tel:+94777777745")
        .then()
                .statusCode(200);
                //.body(("outboundUSSDMessageRequest.responseRequest",hasItems("notifyURL")); //here u can use jsonpath finder extension


    }
}
