package test_data;

import java.util.HashMap;


public class HerOkuAppTestData {
    /*
https://restful-booker.herokuapp.com/booking/4
       {
           "firstname": "Ali",
           "lastname": "Can",
           "totalprice": 220,
           "depositpaid": true,
           "bookingdates": {
                  "checkin": "2022-02-01",
                  "checkout": "2022-02-11"
          }
       }
1) JsonPhat
2) De-Serialization
*/


    public HashMap<String,Object>setUpTestData(){
        HashMap<String,Object> bookingdates=new HashMap<>();
        bookingdates.put("checkin","2022-02-01");
        bookingdates.put("checkout","2022-02-11");

        HashMap<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstname", "Ali");
        expectedData.put("lastname", "Can");
        expectedData.put("totalprice",500);
        expectedData.put("depositpaid", true);
        expectedData.put( "bookingdates",bookingdates);
        return  expectedData;
    }
    }



