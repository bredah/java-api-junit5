package bredah.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class Booking {

    @SerializedName("firstname")
    private String firstName;
    @SerializedName("lastname")
    private String lastName;
    @SerializedName("totalprice")
    private int totalPrice;
    @SerializedName("depositpaid")
    private boolean depositPaid;
    @SerializedName("bookingdates")
    private BookingDates bookingDates;
    @SerializedName("additionalneeds")
    private String additionalNeeds;

    public Booking() {
    }

    public Booking(String firstName, String lastName, int totalPrice, boolean depositPaid, BookingDates bookingDates,
            String additionalNeeds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingDates = bookingDates;
        this.additionalNeeds = additionalNeeds;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDepositPaid() {
        return this.depositPaid;
    }

    public boolean getDepositPaid() {
        return this.depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public BookingDates getBookingDates() {
        return this.bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    public String getAdditionalNeeds() {
        return this.additionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }

    @Override
    public String toString() {
        return "{" + " firstName='" + getFirstName() + "'" + ", lastName='" + getLastName() + "'" + ", totalPrice='"
                + getTotalPrice() + "'" + ", depositPaid='" + isDepositPaid() + "'" + ", bookingDates='"
                + getBookingDates() + "'" + ", additionalNeeds='" + getAdditionalNeeds() + "'" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return Objects.equals(firstName, booking.firstName) && Objects.equals(lastName, booking.lastName)
                && totalPrice == booking.totalPrice && depositPaid == booking.depositPaid
                && Objects.equals(bookingDates, booking.bookingDates)
                && Objects.equals(additionalNeeds, booking.additionalNeeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, totalPrice, depositPaid, bookingDates, additionalNeeds);
    }

}
