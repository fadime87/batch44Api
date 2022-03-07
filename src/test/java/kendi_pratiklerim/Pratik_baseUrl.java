package kendi_pratiklerim;

import base_url.GMIBankBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Pratik_baseUrl extends GMIBankBaseUrl {
     /*
    http://www.gmibank.com/api/tp-customers/114351 adresindeki müşteri bilgilerini doğrulayın

    "firstName": "Della",
    "lastName": "Heaney",
    "mobilePhoneNumber": "123-456-7893",
    "address": "75164 McClure Stream",
    "country" : "USA"
    "state": "New York43"
    "CREDIT_CARD",hesabında 69700$ ,
    "CHECKING" hesabında 11190$
     */

    @Test
    public void  test01(){

        spec03.pathParams("first","tp-customers","second","114351");

        Response response=given().spec(spec03)
                .header("Authorization","Bearer " + generateToken())
                        .when().get("/{first},/{second}");

        response.then().assertThat().body("firstName", Matchers.equalTo("Della")
                , "lastName",Matchers.equalTo("Heaney")
                ,"mobilePhoneNumber",Matchers.equalTo("123-456-7893")
                ,"address",Matchers.equalTo("75164 McClure Stream")
                ,"country",Matchers.equalTo("USA")
                ,"state",Matchers.equalTo("New York43")
                ,"CREDIT_CARD",Matchers.equalTo(69700)
                ,"CHECKING",Matchers.equalTo(11190));

    }

}
