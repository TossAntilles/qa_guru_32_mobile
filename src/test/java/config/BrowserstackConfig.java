package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("APP")
    @DefaultValue("bs://sample.app")
    String app();

    @Key("DEVICE")
    @DefaultValue("Google Pixel 3")
    String device();

    @Key("OS")
    @DefaultValue("9.0")
    String os();


    @Key("PROJECT")
    String project();

    @Key("BUILD")
    String build();

    @Key("NAME")
    String name();

    @Key("BROWSERSTACKURL")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String browserstackUrl();

}