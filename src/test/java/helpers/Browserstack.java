package helpers;

import config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;


public class Browserstack {


    public static String videoUrl(String sessionId) {

        final AuthConfig auth = ConfigFactory.create(AuthConfig.class);

        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(auth.USERNAME(), auth.PASSWORD())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
