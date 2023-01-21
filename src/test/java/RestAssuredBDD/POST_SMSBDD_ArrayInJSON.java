package RestAssuredBDD;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class POST_SMSBDD_ArrayInJSON {

    HashMap maph = new HashMap();

    @Test
    public void smsBDD(){
        maph.put("outboundSMSMessageRequest.senderAddress","tel:7655");
        maph.put("outboundSMSMessageRequest.senderName","6655");

        ArrayList<String> msisdns = new ArrayList<String>();
        msisdns.add("tel:+94779987784");
        msisdns.add("tel:+94779987785");
        maph.put("address",msisdns);

        maph.put("outboundSMSMessageRequest.receiptRequest.callbackData","some-data-useful-to-the-requester");
        maph.put("outboundSMSMessageRequest.receiptRequest.notifyURL","https://localhost:9090/fusing");
        maph.put("outboundSMSMessageRequest.outboundSMSTextMessage.message","test1");
        maph.put("outboundSMSMessageRequest.clientCorrelator","1232");

        given()
            .contentType(ContentType.JSON)
            .body(maph)
        .when()
            .post("http://35.190.132.202:9090/smsmessaging/outbound/tel:7655/requests")
        .then()
            .statusCode(200);
    }
}
