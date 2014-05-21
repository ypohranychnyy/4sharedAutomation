package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class RegistrationOnDivPopup {

    private static final Properties locators;

    static {
        locators = new Properties();
        InputStream is = RegistrationOnDivPopup.class.getResourceAsStream("/locators.properties");
        try {locators.load(is);}
        catch (Exception e) {System.out.println(e.getMessage());}
    }

    @After
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Test

    public void RedirectFromSocialPopup () {

        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();   //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска
        $(byAttribute("href","http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm")).should(Condition.appear);

        open("http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm"); //вручную открываем ссылку с единственным результатом

        $("#btnLink").click(); //D1 - кликаем Скачать

        $(".freeDownloadButton").should(Condition.appear);
        $(".freeDownloadButton").click(); //D2 - кликаем Бесплатная загрузка

        $(byAttribute("data-element","LoginFacebook")).should(Condition.appear);
        $(byAttribute("data-element","socl4")).should(Condition.appear);
        $(byAttribute("data-element","socl4")).click(); //кликаем сайнап

        $(locators.getProperty("authdiv.reg.email")).should(Condition.appear);
        $(locators.getProperty("authdiv.reg.pass")).should(Condition.appear);
        $(locators.getProperty("authdiv.reg.confirmpass")).should(Condition.appear);
        //$("#signupEmailField").should(Condition.appear);
        //$("#signupPassField").should(Condition.appear);
        //$("#signupPassFieldRepeat").should(Condition.appear); //авторизационный див

        $(locators.getProperty("authdiv.reg.email")).val("qwert123@qwert.qwe");
        $(locators.getProperty("authdiv.reg.pass")).val("1");
        $(locators.getProperty("authdiv.reg.confirmpass")).val("1");
        $(locators.getProperty("authdiv.reg.confirmbutton")).click(); //заполняем див

        $("#step1Regloginfield").should(Condition.appear);
        $("#step1Regloginfield").shouldHave(Condition.value("qwert123@qwert.qwe"));
        $("#step1Regpassfield").shouldHave(Condition.value("1"));
        $("#step1Regpassfield2").shouldHave(Condition.value("1"));
        $("#registrationSubmit").should(Condition.appear); // подтверждаем, что мы на веб акк сайнап

    }

    @Test

    public void RedirectFromShare() {

        open("http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm"); //вручную открываем ссылку с единственным результатом
        $("#shareWithFriendsButton").should(Condition.appear);
        $("#shareWithFriendsButton").click();

        $(locators.getProperty("authdiv.reg.email")).should(Condition.appear);
        $(locators.getProperty("authdiv.reg.pass")).should(Condition.appear);
        $(locators.getProperty("authdiv.reg.confirmpass")).should(Condition.appear);
        //$("#signupEmailField").should(Condition.appear);
        //$("#signupPassField").should(Condition.appear);
        //$("#signupPassFieldRepeat").should(Condition.appear); //авторизационный див

        $(locators.getProperty("authdiv.reg.email")).val("qwert123@qwert.qwe");
        $(locators.getProperty("authdiv.reg.pass")).val("1");
        $(locators.getProperty("authdiv.reg.confirmpass")).val("1");
        $(locators.getProperty("authdiv.reg.confirmbutton")).click(); //заполняем див

        $("#step1Regloginfield").should(Condition.appear);
        $("#step1Regloginfield").shouldHave(Condition.value("qwert123@qwert.qwe"));
        $("#step1Regpassfield").shouldHave(Condition.value("1"));
        $("#step1Regpassfield2").shouldHave(Condition.value("1"));
        $("#registrationSubmit").should(Condition.appear); // подтверждаем, что мы на веб акк сайнап

    }

    @Test

    public void RedirectFromAddToMyAcc() {

        open("http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm"); //вручную открываем ссылку с единственным результатом

        $(byAttribute("data-element","20")).should(Condition.appear);
        $(byAttribute("data-element","20")).click(); //кликаем add to my acc

        $(locators.getProperty("authdiv.reg.email")).should(Condition.appear);
        $(locators.getProperty("authdiv.reg.pass")).should(Condition.appear);
        $(locators.getProperty("authdiv.reg.confirmpass")).should(Condition.appear);
        //$("#signupEmailField").should(Condition.appear);
        //$("#signupPassField").should(Condition.appear);
        //$("#signupPassFieldRepeat").should(Condition.appear); //авторизационный див

        $(locators.getProperty("authdiv.reg.email")).val("qwert123@qwert.qwe");
        $(locators.getProperty("authdiv.reg.pass")).val("1");
        $(locators.getProperty("authdiv.reg.confirmpass")).val("1");
        $(locators.getProperty("authdiv.reg.confirmbutton")).click(); //заполняем див

        $("#step1Regloginfield").should(Condition.appear);
        $("#step1Regloginfield").shouldHave(Condition.value("qwert123@qwert.qwe"));
        $("#step1Regpassfield").shouldHave(Condition.value("1"));
        $("#step1Regpassfield2").shouldHave(Condition.value("1"));
        $("#registrationSubmit").should(Condition.appear); // подтверждаем, что мы на веб акк сайнап
    }

    @Test

    public void RedirectFromAddToMyAccSearchPage() {

        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();   //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска
        $(byAttribute("href","http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm")).should(Condition.appear);

        $(byAttribute("data-element","20")).click(); //кликаем add to my acc

        $(locators.getProperty("authdiv.reg.email")).should(Condition.appear);
        $(locators.getProperty("authdiv.reg.pass")).should(Condition.appear);
        $(locators.getProperty("authdiv.reg.confirmpass")).should(Condition.appear);
        //$("#signupEmailField").should(Condition.appear);
        //$("#signupPassField").should(Condition.appear);
        //$("#signupPassFieldRepeat").should(Condition.appear); //авторизационный див

        $(locators.getProperty("authdiv.reg.email")).val("qwert123@qwert.qwe");
        $(locators.getProperty("authdiv.reg.pass")).val("1");
        $(locators.getProperty("authdiv.reg.confirmpass")).val("1");
        $(locators.getProperty("authdiv.reg.confirmbutton")).click(); //заполняем див

        $("#step1Regloginfield").should(Condition.appear);
        $("#step1Regloginfield").shouldHave(Condition.value("qwert123@qwert.qwe"));
        $("#step1Regpassfield").shouldHave(Condition.value("1"));
        $("#step1Regpassfield2").shouldHave(Condition.value("1"));
        $("#registrationSubmit").should(Condition.appear); // подтверждаем, что мы на веб акк сайнап
    }

    @Test

    public void RedirectFromDevelopPage() {

        open("https://www.4shared.com/developer/docs/app/"); //открываем 4shared

        $(locators.getProperty("authdiv.reg.email")).should(Condition.appear);
        $(locators.getProperty("authdiv.reg.pass")).should(Condition.appear);
        $(locators.getProperty("authdiv.reg.confirmpass")).should(Condition.appear);
        //$("#signupEmailField").should(Condition.appear);
        //$("#signupPassField").should(Condition.appear);
        //$("#signupPassFieldRepeat").should(Condition.appear); //авторизационный див

        $(locators.getProperty("authdiv.reg.email")).val("qwert123@qwert.qwe");
        $(locators.getProperty("authdiv.reg.pass")).val("1");
        $(locators.getProperty("authdiv.reg.confirmpass")).val("1");
        $(locators.getProperty("authdiv.reg.confirmbutton")).click(); //заполняем див

        $("#step1Regloginfield").should(Condition.appear);
        $("#step1Regloginfield").shouldHave(Condition.value("qwert123@qwert.qwe"));
        $("#step1Regpassfield").shouldHave(Condition.value("1"));
        $("#step1Regpassfield2").shouldHave(Condition.value("1"));
        $("#registrationSubmit").should(Condition.appear); // подтверждаем, что мы на веб акк сайнап

    }

    }
