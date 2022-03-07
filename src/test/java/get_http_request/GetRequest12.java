package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utulities.Authentication;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends Authentication {
   //Authenticatio class in icerisindeki generatToken methodu kullanilacak

    String endPoint ="http://www.gmibank.com/api/tp-customers";

    @Test
    public void test12(){
        Response response=given()
                .header("Authorization","Bearer "+ generateToken())
                        .when()
                        .get(endPoint)
                .then()
                .extract()
                .response();
        response.prettyPeek();

        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);

    }
}
