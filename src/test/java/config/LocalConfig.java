package config;

import org.aeonbits.owner.Config;

    @Config.Sources({
            "classpath:local.properties"
    })
    public interface LocalConfig extends Config {

        @Key("DEVICE")
        @DefaultValue("Pixel 4 API 30")
        String DEVICE();

        @Key("OSVERSION")
        @DefaultValue("11")
        String OSVERSION();


        @Key("APP")
        @DefaultValue("org.wikipedia.alpha")
        String APP();

        @Key("APPVERSION")
        @DefaultValue("alpha-universal-release.apk")
        String APPVERSION();

        @Key("APPURL")
        @DefaultValue("https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/")
        String APPURL();

        @Key("APPACTIVITY")
        @DefaultValue("org.wikipedia.main.MainActivity")
        String APPACTIVITY();

}
