package bredah.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
  "system:properties",
  "classpath:auth.properties"
})
public interface AuthenticationConfig extends Config {
  
  @Key("auth.username")
  String username();

  @Key("auth.password")
  String password();

}
