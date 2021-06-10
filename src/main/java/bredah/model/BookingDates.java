package bredah.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class BookingDates {
  @SerializedName("checkin")
  private String checkin;
  @SerializedName("checkout")
  private String checkout;

  public BookingDates() {
  }

  public BookingDates(String checking, String checkout) {
    this.checkin = checking;
    this.checkout = checkout;
  }

  public String getCheckin() {
    return this.checkin;
  }

  public void setCheckin(String checkin) {
    this.checkin = checkin;
  }

  public String getCheckout() {
    return this.checkout;
  }

  public void setCheckout(String checkout) {
    this.checkout = checkout;
  }

  @Override
  public String toString() {
    return "{" + " checkin='" + getCheckin() + "'" + ", checkout='" + getCheckout() + "'" + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof BookingDates)) {
      return false;
    }
    BookingDates bookingDates = (BookingDates) o;
    return Objects.equals(checkin, bookingDates.checkin) && Objects.equals(checkout, bookingDates.checkout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checkin, checkout);
  }

}
