package kendi_pratiklerim;

import base_url.GMIBankBaseUrl;
import groovy.transform.ASTTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Pratik_GMIbank extends GMIBankBaseUrl {
     /*
    https://www.gmibank.com/api/tp-customers/85694
    "login": "dino.kohler",
    "firstName": "Winona",
    "lastName": "Abernathy",
     "email": "winonaabernathy@gmail.com"

     */

   @Test
    public void test01(){
       spec03.pathParams("first","tp-customers","second","85694");

       Response response=given().spec(spec03).header("Authorization","Bearer " + generateToken())
               .when().get("/{first}/{second}");

       response.then().assertThat().body("login", Matchers.equalTo("dino.kohler")
                   ,"firstName",Matchers.equalTo("Winona")
                   ,"lastName",Matchers.equalTo("Abernathy")
                   ,"email",Matchers.equalTo("winonaabernathy@gmail.com"));



       JsonPath json= response.jsonPath();
       Assert.assertEquals("dino.kohler",json.get("login"));
       Assert.assertEquals("Winona",json.get("firstName"));
       Assert.assertEquals("Abernathy",json.get("lastName"));
       Assert.assertEquals("winonaabernathy@gmail.com",json.get("email"));

    }

}
