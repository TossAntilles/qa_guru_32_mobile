package config;

import org.aeonbits.owner.Config;

@Config.Sources(
        {"classpath:authData.properties"}
)

public interface AuthConfig extends Config {
    String USERNAME();
    String PASSWORD();
}
