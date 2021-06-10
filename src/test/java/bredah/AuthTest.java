package bredah;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import bredah.model.Authentication;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Feature("Authentication")
public class AuthTest extends BaseAPI{
  
  @Test
  @Tag("functional")
  @DisplayName("Create token")
  @Severity(SeverityLevel.CRITICAL)
  public void ping() {
    Authentication auth = new Authentication(authConfig.username(), authConfig.password());
    String token = given()
      .header("Content-type", "application/json")
      .body(gson.toJson(auth))
    .when()
      .post("/auth")
    .then()
      .statusCode(HttpStatus.SC_OK)
      .extract()
        .jsonPath().getString("token");

    assertNotNull("token can not be null or empty", token);
  }
}
