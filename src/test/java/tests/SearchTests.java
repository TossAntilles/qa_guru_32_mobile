package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка наличия статей")
    void successfulArticleSearchTest() {
        step("Проверка имени статьи в поиске", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Nintendo");
        });
        step("Проверка результатов поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Открыть найденную статью")
    void successfulOpenArticleTest() {
        step("Вводим поиск слова", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("search_src_text")).sendKeys("Nintendo");
        });
        step("Открываем найденную статью", () -> $(id("page_list_item_title")).click());
        step("Проверяем статью", () -> {
            $(className("android.widget.TextView")).shouldHave(text("Nintendo Co., Ltd.[c] is a Japanese multinational video game company headquartered in Kyoto"));
        });
    }
}