package bredah;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bredah.model.Booking;
import bredah.model.BookingDates;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Feature("Booking")
public class BookingTest extends BaseAPI {
   
    @Test
    @Tag("e2e")
    @DisplayName("Create a new booking")
    @Severity(SeverityLevel.CRITICAL)
    public void createNewBooking() {
        given()
            .header("Content-type", "application/json")
            .body(gson.toJson(getBookingData()))
        .when()
            .post("/booking")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body(matchesJsonSchemaInClasspath("schemas/booking_register_schema.json"));
    }

    @Test
    @Tag("e2e")
    @DisplayName("Update a booking")
    @Severity(SeverityLevel.CRITICAL)
    public void updateBooking() {
        Booking booking = getBookingData();
        int bookingId = registerNewBooking(booking);

        booking.setFirstName("Zack");
        booking.setFirstName("Snyder");

        String responseBody = given()
            .auth().preemptive().basic(authConfig.username(), authConfig.password())
            .header("Content-type", "application/json")
            .header("Accept", "application/json")
            .body(gson.toJson(booking))
        .when()
            .put("/booking/" + bookingId)
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body(matchesJsonSchemaInClasspath("schemas/booking_schema.json"))
            .extract().asString();
        
        Booking updatedBooking = gson.fromJson(responseBody, Booking.class);
        assertEquals(updatedBooking, booking);
    }

    @Test
    @Tag("e2e")
    @DisplayName("Delete a booking")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteBooking() {
        int bookingId = registerNewBooking(getBookingData());

        given()
            .auth().preemptive().basic(authConfig.username(), authConfig.password())
            .header("Content-type", "application/json")
        .when()
            .delete("/booking/" + bookingId)
        .then()
            .statusCode(HttpStatus.SC_CREATED);
    }

    private Booking getBookingData(){
        return new Booking("Joseph", "Climber", 100, Boolean.TRUE, new BookingDates("2020-04-20", "2022-04-20"), "Dinner");
    }

    private int registerNewBooking(Booking booking){
        return given()
                .header("Content-type", "application/json")
                .body(gson.toJson(booking))
            .when()
                .post("/booking")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath().getInt("bookingid");
    }
}
