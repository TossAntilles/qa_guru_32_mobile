package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:android.properties"
})
public interface BrowserstackConfig extends Config {
    String APP();
    String DEVICE();
    String OS();

    String PROJECT();
    String BUILD();
    String NAME();

    String BROWSERSTACKURL();

}
