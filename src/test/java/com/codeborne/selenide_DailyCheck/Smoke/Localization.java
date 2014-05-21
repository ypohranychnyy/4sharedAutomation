package com.codeborne.selenide_DailyCheck.Smoke;

import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

/**
 * Created by User on 16.04.2014.
 */
public class Localization {


    @Test

    public void UserCanChangeLang() {

        open("https://www.4shared.com"); //открываем 4shared
        $(byAttribute("data-element", "h15")).click();
        $("#changeLang").click();
        $(byAttribute("data-element", "h18-ru")).click(); //меняем язык на русский
        $(byAttribute("data-element", "h18-ru")).should(Condition.disappear);
        $(".rbox .button-orange").should(Condition.appear);
        $(".rbox .button-orange").shouldHave(Condition.text("Регистрация"));

        $(byAttribute("data-element", "h15")).click();
        $("#changeLang").click();
        $(byAttribute("data-element", "h18-en")).click(); //меняем язык на англ
        $(byAttribute("data-element", "h18-en")).should(Condition.disappear);
        $(".rbox .button-orange").should(Condition.appear);
        $(".rbox .button-orange").shouldHave(Condition.text("Sign Up"));

        $(byAttribute("data-element", "h15")).click();
        $("#changeLang").click();
        $(byAttribute("data-element", "h18-th")).click(); //меняем язык на тайский
        $(byAttribute("data-element", "h18-th")).should(Condition.disappear);
        $(".rbox .button-orange").should(Condition.appear);
        $(".rbox .button-orange").shouldHave(Condition.text("ลงทะเบียน"));

        $(byAttribute("data-element", "h15")).click();
        $("#changeLang").click();
        $(byAttribute("data-element", "h18-pt-BR")).click(); //меняем язык на португальский
        $(byAttribute("data-element", "h18-pt-BR")).should(Condition.disappear);
        $(".rbox .button-orange").should(Condition.appear);
        $(".rbox .button-orange").shouldHave(Condition.text("Inscrever-se"));

    }

}
