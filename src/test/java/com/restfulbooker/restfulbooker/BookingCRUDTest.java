package com.restfulbooker.restfulbooker;

import com.restfulbooker.model.BookingPojo;
import com.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingCRUDTest extends TestBase {

    @Test
    public void getAllBookingId()
    {
        Response response = given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void CreateData()
    {
        HashMap<String,String> bookingdates = new HashMap<>();
        bookingdates.put("checkin","2021-09-10");
        bookingdates.put("checkout","2021-10-20");



        BookingPojo bookingPojo =new BookingPojo();
        bookingPojo.setFirstname("Divyaaa");
        bookingPojo.setLastname("Patelaa");
        bookingPojo.setTotalprice(560);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalNeeds("Bat Dish");

        Response response = given()
                .header("Content-Type","application/json")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();


    }
    @Test
    public void PatchUpdateData()
    {
        BookingPojo bookingPojo =new BookingPojo();
        bookingPojo.setFirstname("Divyaarn");
        bookingPojo.setLastname("Patellgf");
        bookingPojo.setTotalprice(565);


        Response response = given()

                .basePath("/booking")
                .header("Content-Type","application/json")
                //.pathParam("token","8af175a14540108")
                .body(bookingPojo)
                .when()
                .patch("876");
        response.then();
        response.prettyPrint();


    }
    @Test
    public void DeleteData()
    {
        Response response = given()
                .basePath("/booking")
                .pathParam("id","3009")
                .when()
                .delete("/{id}");
        response.then();
        response.prettyPrint();


    }

}
