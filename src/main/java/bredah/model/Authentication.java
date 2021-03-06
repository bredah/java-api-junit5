package bredah.model;

import com.google.gson.annotations.SerializedName;

public class Authentication {

  @SerializedName("username")
  private String username;
  @SerializedName("password")
  private String password;

  public Authentication() {
  }

  public Authentication(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
