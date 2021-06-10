package bredah;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


import static io.restassured.RestAssured.given;

@Feature("Health Check")
public class HealthCheckTest extends BaseAPI {

  @Test
  @Tag("health")
  @DisplayName("Health check")
  @Severity(SeverityLevel.CRITICAL)
  public void ping() {
    given()
      .header("Content-type", "application/json")
    .when()
      .get(configuration.health())
    .then()
      .statusCode(HttpStatus.SC_CREATED);
  }

}
