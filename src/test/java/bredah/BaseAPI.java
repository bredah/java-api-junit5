package bredah;

import com.google.gson.Gson;

import org.junit.jupiter.api.BeforeAll;

import bredah.config.AuthenticationConfig;
import bredah.config.Configuration;
import bredah.config.ConfigurationManager;
import io.restassured.RestAssured;

public abstract class BaseAPI {

  protected static Configuration configuration;
  protected static AuthenticationConfig authConfig;

  protected Gson gson = new Gson();

  @BeforeAll
  public static void beforeAllTests() {
    configuration = ConfigurationManager.getConfiguration();
    authConfig = ConfigurationManager.getAuthentication();
    RestAssured.baseURI = configuration.baseURI();
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

}
