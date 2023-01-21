package RestAssuredBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class ValidateMultipleResponse {

    @Test(priority = 1)
    public void multiplValueBDD(){
        given()
           .when()
                .get("http://services.groupkt.com/country/get/all")
           .then()
                .body("RestResponse.result.name",hasItems("Sri Lanka","India","New Zeland"));
    }

    public void addtestParamAndHeaders(){
        given()
                .param("City","Kalutara")
                .header("Accept","json")
           .when()
                .get("http://services.groupkt.com/country/get/all")
           .then()
                .body("RestResponse.result.name",hasItems("Sri Lanka","India","New Zeland"))
                .log().all();
    }
}
