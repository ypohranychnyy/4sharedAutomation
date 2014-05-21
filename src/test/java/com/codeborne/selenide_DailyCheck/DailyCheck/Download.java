package com.codeborne.selenide_DailyCheck.DailyCheck;

import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class Download {

    @After
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Test
    public void UserCanDownload() {
        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();   //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска
        $(byAttribute("href","http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm")).should(Condition.appear);

        open("http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm"); //вручную открываем ссылку с единственным результатом

        $("#btnLink").click(); //D1 - кликаем Скачать

        $(".freeDownloadButton").should(Condition.appear);
        $(".freeDownloadButton").click(); //D2 - кликаем Бесплатная загрузка

        $(byAttribute("data-element","LoginFacebook")).should(Condition.appear);
        $(byAttribute("data-element","LoginFacebook")).click(); //Social Download popup - выбираем ФБ

        $("#email").waitUntil(Condition.appear,15000);
        $("#email").val("fb@deng.4shared.com"); //
        $("#pass").val("5326776DR");
        $("#u_0_1").click(); // Логинимся в аккаунт ФБ

        $("#downloadDelayTimeSec").waitUntil(Condition.disappear,30000); // Ждем пока пропадет каунтер

        $(byText("Благодарим за скачивание файла")).shouldBe(Condition.visible); //D3 - Проверяем попали ли мы на D3
        $(".db .premium").shouldBe(Condition.visible);


    }

}
