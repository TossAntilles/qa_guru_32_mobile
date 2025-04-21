package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    private static final BrowserstackConfig bs = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    private static final AuthConfig auth = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", auth.username());
        caps.setCapability("browserstack.key", auth.password());

        // Set URL of the application under test
        caps.setCapability("app", bs.app());

        // Specify device and os_version for testing
        caps.setCapability("device", bs.device());
        caps.setCapability("os_version", bs.os());

        // Set other BrowserStack capabilities
        caps.setCapability("project", bs.project());
        caps.setCapability("build", bs.build());
        caps.setCapability("name", bs.name());

        try {
            return new RemoteWebDriver(
                    new URL(bs.browserstackUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
