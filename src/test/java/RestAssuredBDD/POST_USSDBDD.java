package RestAssuredBDD;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POST_USSDBDD {

    public static HashMap map = new HashMap();

    @BeforeMethod
    public void postdata(){
        map.put("FirstName",Util_RandomGenerate.getFirstName());
        map.put("LastName",Util_RandomGenerate.getLastName());
        map.put("Username",Util_RandomGenerate.getUsernameName());
        map.put("Password",Util_RandomGenerate.getPassword());
        map.put("Email",Util_RandomGenerate.getEmail());

        RestAssured.baseURI = "http://35.190.132.202:9090/smsmessaging/outbound/tel:7655/requests";
    }

    @Test
    public void ussdBDD(){
        given()
               .contentType("application/json")
               .body(map)

           .when()
                .post()

           .then()
                .statusCode(201)
                .and()
                .body("outboundSMSMessageRequest.senderAddress",equalTo("tel:12345678"));

    }

}
