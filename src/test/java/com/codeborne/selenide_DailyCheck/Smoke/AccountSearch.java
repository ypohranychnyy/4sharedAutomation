package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AccountSearch {

    @Test

    public void UserCanDoAccSearch() {

        open("https://www.4shared.com"); // Открываем 4ш

        $(".controls .llink").click(); //Жмем логин в хедере
        $(".headLoginDropdown").should(appear); //Ждем дропдаун
        $(".jsInputLogin").val("test5@deng.4shared.com");
        $(".jsInputPassword").val("1").pressEnter(); // логиминся
        $("#foldertree").should(Condition.appear); // попадаем в акк

        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").val("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска
        $(byAttribute("data-element", "20")).click(); // нажимаем Add to my acc

        $((".server-info .notify-msg")).waitUntil(Condition.appears,6000); //Ждем появления зеленого хинта в хедере
        $(".gaClick .absmid").click();
        $(byAttribute("data-element", "h26")).click(); //переходим в акк

        $("#foldertree").should(Condition.appear); //подтверждаем попали ли мы в акк
        $("#searchQuery").val("gta test.mp3").pressEnter();

        $(".searchDivider.ownFiles>td").should(Condition.appear);
        $(byText("04-24-2014")).shouldBe(present);

        $(byAttribute("data-element", "h25_01")).shouldBe(present); // торможу тесты
        $(byAttribute("data-element", "h25_01")).click(); // рефрешу акк
        $("#foldertree").should(Condition.appear);

        //$(".commandDetailsView").click(); // переключаемся на детальный вид

        $(".checkFiles.jsCheckAll").click();
        $(byAttribute("data-element","fm-4.4")).should(appear); //Появляется кнопка "Delete"
        $(byAttribute("data-element","fm-4.4")).click(); //Жмем удалить
        $((".confirmPopupBlueButton ")).click(); //Подтверждаем удаление
        $(byAttribute("data-element","viewL-tr")).waitUntil(disappear, 10000);
    }
}
