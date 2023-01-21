package RestAssuredBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GET_LocationValidation {

    @Test
    public void locationBDD(){

        given()
        .when()
             .get("http://35.190.132.202:9090/location/queries/location?address=tel:+94777777771&requestedAccuracy=1000")
        .then()
             .statusCode(200)
             .statusLine("HTTP/1.1 200 OK")
             .assertThat().body("terminalLocationList.terminalLocation.address", equalTo("tel:9412345678"))
             .header("Content-Type","application/json; charset=UTF8");


    }
}
