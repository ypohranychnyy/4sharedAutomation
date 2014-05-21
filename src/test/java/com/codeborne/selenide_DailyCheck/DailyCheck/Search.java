package com.codeborne.selenide_DailyCheck.DailyCheck;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byAttribute;

@RunWith(SeleniumRunner.class)

public class Search {

    @Test
    public void UserCanSearch() {
        open("https://www.4shared.com"); //открываем 4shared

        $(byAttribute("data-element", "h15")).click();
        $("#changeLang").click();
        $(byAttribute("data-element", "h18-en")).click(); //меняем язык на англ, чтобы точно быть уверенными
        $(byAttribute("data-element", "h18-en")).should(Condition.disappear);

        $(".lbox .proceed ").should(Condition.appear);
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска

        $("#s1").click(); //Сортируем по просмотрам(за все время), чтобы получить больше результатов
        $(byAttribute("data-element", "r1.3")).shouldBe(Condition.visible);
        $(byAttribute("data-element", "r10.3")).shouldBe(Condition.visible); //Проверяем наличие первого и последнего результата на странице поиска
        $(By.id("total_q")).shouldNotHave(Condition.value("0")); //Проверяем, что количество результатов не равно "0"

        $("#s2").click(); //Сортируем по дате, чтобы проверить отсутствие пробелов
        $(byAttribute("data-element", "r1.3")).shouldBe(Condition.visible);
        $(byAttribute("data-element", "r10.3")).shouldBe(Condition.visible); //Проверяем наличие первого и последнего результата на странице поиска
        $(By.id("total_q")).shouldNotHave(Condition.value("0")); //Проверяем, что количество результатов не равно "0"
       //$(".fdate").shouldHave(Condition.text("less than a minute ago")); // не нужно
    }
}
