package tests;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Проверка наличия статьи")
    void successfulArticleSearchTest() {
        step("Проверка имени статьи в поиске", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Nintendo");
        });
        step("Проверка результатов поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().shouldHave(text("Nintendo"))
        );
    }

    @Test
    @DisplayName("Попытка открыть найденную статью")
    void unsuccessfulOpeningAnArticleTest() {
        step("Поиск статьи", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Nintendo");
        });
        step("Открытие первой статьи в списке", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click()
        );
        step("Проверка ошибки при открытии статьи", () ->
                $(className("android.widget.TextView")).shouldHave(text("An error occurred"))
        );
    }

    @Disabled
    @Test
    @DisplayName("Проверка вкладки Saved")
    void openSavedTabTest() {
        step("Открыть вкладку Saved", () -> {
            $(id("org.wikipedia.alpha:id/nav_tab_reading_lists")).click();
        });
        step("Проверка заголовка", () -> {
            $(id("org.wikipedia.alpha:id/messageTitleView")).shouldHave(text("Sync reading lists"));
            $(id("org.wikipedia.alpha:id/messageTextView")).shouldHave(text("Reading lists can now be synced across devices. Log in to your Wikipedia account and allow your lists to be saved."));
        });
        step("Проверка кнопки Log In на странице", () -> {
            $(className("org.wikipedia.alpha:id/positiveButton")).shouldBe(visible);
            $(className("org.wikipedia.alpha:id/positiveButton")).shouldHave(text("Log in / join Wikipedia"));
        });
    }
}
