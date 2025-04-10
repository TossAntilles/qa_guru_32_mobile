package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Проверка наличия статьи")
    @Tag("InstalledApp")
    void successfulLocalArticleSearchTest() {
        step("Предусловие: закрыть входное окно ", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Проверка имени статьи в поиске", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Nintendo");
        });
        step("Проверка результатов поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().shouldHave(text("Nintendo"))
        );
    }

    @Test
    @DisplayName("Попытка заголовков статью")
    @Tag("InstalledApp")
    void successfulLocalOpeningAnArticleTest() {
        step("Предусловие: закрыть входное окно ", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Поиск статьи", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Nintendo");
        });
        step("Открытие первой статьи в списке", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click()
        );
        step("Предусловие: закрыть рекламное окно ", () -> {
            $(id("org.wikipedia.alpha:id/closeButton")).click();
        });
        step("Проверка заголовка и подзаголовка", () -> {
            $$(className("android.view.View")).first().shouldHave(text("Nintendo"));
            $(id("org.wikipedia.alpha:id/pcs-edit-section-title-description")).shouldHave(text("Japanese video game company"));
        });
    }


    @Test
    @DisplayName("Проверка вкладки Saved")
    @Tag("InstalledApp")
    void successfulLocalOpenSavedTabTest() {
        step("Предусловие: закрыть входное окно ", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Открыть вкладку Saved", () -> {
            $(id("org.wikipedia.alpha:id/nav_tab_reading_lists")).click();
        });
        step("Проверка заголовка", () -> {
            $(id("org.wikipedia.alpha:id/messageTitleView")).shouldHave(text("Sync reading lists"));
            $(id("org.wikipedia.alpha:id/messageTextView")).shouldHave(text("Reading lists can now be synced across devices. Log in to your Wikipedia account and allow your lists to be saved."));
        });
        step("Проверка кнопки Log In на странице", () -> {
            $(id("org.wikipedia.alpha:id/positiveButton")).shouldBe(visible);
            $(id("org.wikipedia.alpha:id/positiveButton")).shouldHave(text("Log in / join Wikipedia"));
        });
    }


    @Test
    @DisplayName("Проверка наличия статьи")
    @Tag("Browserstack")
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
    @Tag("Browserstack")
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

}
