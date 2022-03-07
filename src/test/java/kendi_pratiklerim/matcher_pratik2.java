package kendi_pratiklerim;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class matcher_pratik2 {
 /*
       https://jsonplaceholder.typicode.com/todos/12" url'ine
       accept type'i "application/json" olan GET request'i yolladigimda
   gelen response'un
         status kodunun 200
          ve content type'inin "application/json"

         ve response body'deki "userId"'nin 1
         ve "title" in "ipsa repellendus fugit nisi"
         ve "completed" bolumunun true oldugunu test edin
     */
    @Test
    public void test02(){
        String url="https://jsonplaceholder.typicode.com/todos/12";
        Response response=given().when().get(url);
        response.prettyPrint();

        response.then().assertThat()
                            .statusCode(200)
                .contentType("application/json");
        response.then().assertThat().body("userId" , Matchers.equalTo(1)
                                   ,"title", Matchers.equalTo("ipsa repellendus fugit nisi")
                                  ,"completed", Matchers.equalTo(true));
    }
}
