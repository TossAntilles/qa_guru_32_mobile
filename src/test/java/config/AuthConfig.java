package config;

import org.aeonbits.owner.Config;

@Config.Sources(
        {"classpath:authData.properties"}
)

public interface AuthConfig extends Config {

    @Key("USERNAME")
    @DefaultValue("toss_u3SGJg")
    String USERNAME();


    @Key("PASSWORD")
    @DefaultValue("GxCha39Gauu2aZT7czCV")
    String PASSWORD();

}