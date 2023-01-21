package RestAssuredBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class XMLResponseValidation {

    @Test(priority = 1)
    public void xmlResponseVali(){

        //Verify single content from the xml response
        given()
           .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
           .then()
                .body("CUSTOMER.ID", equalTo("10"))
                .log().all();
    }

    //Verify multiple contents of the xml response
    @Test(priority = 2)
    public void xmlValidateMultiContent(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .body("CUSTOMER.ID", equalTo("10"))
                .body("CUSTOMER.FIRSTNAME", equalTo("Sue"))
                .body("CUSTOMER.LASTNAME", equalTo("Fuller"))
                .log().all();
    }

    //Verify all contents of the xml response
    @Test(priority = 3)
    public void xmlValidateAllContent(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas"))
                .log().all();
    }

    //Find xml path in xml response body - 01
    @Test(priority = 4)
    public void xmlPathFindFromXMLResponse01(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .body(hasXPath("/CUSTOMER/ID"), containsString("10")) //first '/' mean root node
                .log().all();

    }

    //Find xml path in xml response body - 02
    @Test(priority = 5)
    public void xmlPathFindFromXMLResponse02(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/INVOICE")
                .then()
                .body(hasXPath("/INVOICEList/INVOICE[text()='30']"), containsString("10")) //first '/' mean root node
                .log().all();

    }
}
