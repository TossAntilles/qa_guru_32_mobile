package config;

import org.aeonbits.owner.Config;

    @Config.Sources({
            "classpath:local.properties"
    })
    public interface LocalConfig extends Config {

        @Key("DEVICE")
        @DefaultValue("Pixel 4 API 30")
        String device();

        @Key("OSVERSION")
        @DefaultValue("11")
        String osVersion();


        @Key("APP")
        @DefaultValue("org.wikipedia.alpha")
        String app();

        @Key("APPVERSION")
        @DefaultValue("alpha-universal-release.apk")
        String appVersion();

        @Key("APPURL")
        @DefaultValue("https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/")
        String appUrl();

        @Key("APPACTIVITY")
        @DefaultValue("org.wikipedia.main.MainActivity")
        String appActivity();

}
