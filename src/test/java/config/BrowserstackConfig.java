package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("APP")
    @DefaultValue("bs://sample.app")
    String APP();

    @Key("DEVICE")
    @DefaultValue("Google Pixel 3")
    String DEVICE();

    @Key("OS")
    @DefaultValue("9.0")
    String OS();


    @Key("PROJECT")
    String PROJECT();

    @Key("BUILD")
    String BUILD();

    @Key("NAME")
    String NAME();

    @Key("BROWSERSTACKURL")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String BROWSERSTACKURL();

}