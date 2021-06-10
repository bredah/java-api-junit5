package bredah.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {
  private ConfigurationManager(){}

  public static Configuration getConfiguration(){
    return ConfigCache.getOrCreate(Configuration.class);
  }

  public static AuthenticationConfig getAuthentication(){
    return ConfigCache.getOrCreate(AuthenticationConfig.class);
  }
}
