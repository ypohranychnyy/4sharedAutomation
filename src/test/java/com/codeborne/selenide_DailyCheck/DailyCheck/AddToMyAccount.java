package com.codeborne.selenide_DailyCheck.DailyCheck;


import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class AddToMyAccount {

    @Before
    public void StartThisSession() {
        clearBrowserCache();
    }


    @Test
    public void UserCanAddToMyAccount() {

        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска

        $(byAttribute("data-element", "20")).should(appear);
        $(byAttribute("data-element", "20")).click(); // нажимаем Add to my acc, получаем авторизационный див

        sleep(5000);

        $("#loginfield").should(appear);
        $("#loginfield").val("Test1@deng.4shared.com");
        $("#passfield").val("1");
        $(".authLoginButton").click(); // Авторизуемся
        $(".authLoginButton").should(disappear);

        $((".server-info .notify-msg")).waitUntil(Condition.appear, 6000); //Ждем появления зеленого хинта в хедере
        $(".gaClick .absmid").click();
        $(byAttribute("data-element", "h26")).click();

        $(byAttribute("data-element", "viewT-tr")).shouldBe(present);

        $(byAttribute("data-element", "fm-4.4")).waitUntil(appear, 10000); //Появляется кнопка "Delete"
        $(byAttribute("data-element", "fm-4.4")).click(); //Жмем удалить
        $(".confirmPopupBlueButton").click(); //Подтверждаем удаление
        $(byAttribute("data-element", "viewT-tr")).waitUntil(disappear, 10000);

        $(byAttribute("data-element", "h25")).click();
        $(byAttribute("data-element", "h27")).click();
        $("#sign_form_log").waitUntil(appear, 10000);
    }
}
