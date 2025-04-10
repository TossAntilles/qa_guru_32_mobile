package config;

import org.aeonbits.owner.Config;

    @Config.Sources({
            "classpath:local.properties"
    })
    public interface LocalConfig extends Config {
        String DEVICE();
        String OSVERSION();

        String APP();
        String APPVERSION();
        String APPURL();
        String APPACTIVITY();



}
