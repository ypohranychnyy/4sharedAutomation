package com.codeborne.selenide_DailyCheck.DailyCheck;

import org.junit.After;
import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class Registration {

    private static final Properties locators;

    static {
        locators = new Properties();
        InputStream is = Registration.class.getResourceAsStream("/locators.properties");
        try {locators.load(is);}
        catch (Exception e) {System.out.println(e.getMessage());}
    }

    @After
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Test

    public void UserCanRegister() {

        open("http://www.fakeinbox.com/"); //Открываем сайт временной почты
        $(".t12l_get_email_button>input").should(appear);
        $(".t12l_get_email_button>input").click();
        $(".t12l_address_input").should(appear);
        $(".t12l_address_input").click();
        String email = $(".t12l_address_input").val();


        open("https://www.4shared.com");

        $(".rbox .button-orange").waitUntil(appear, 5000);
        $(".rbox .button-orange").pressEnter();

        $("#step1Regloginfield").val(email);
        $("#step1Regpassfield").val("9");
        $("#step1Regpassfield2").val("9");
        $("#step1firstname").val("9");
        $("#step1lastname").val("9");

        //$(locators.getProperty("registration.submit")).click();
        $("#registrationSubmit").click(); //Регистрируемся

        $("#resend").should(appear); //второй шаг регистрации

        open("http://www.fakeinbox.com/");

        $(byAttribute("title", "Reload")).click();
        $(byText("Show")).waitUntil(appear, 240000);
        $(byText("Show")).click();
        $(withText("https://www.4shared.com/verifyEmail.jsp")).click(); //Кликаем на ссылку в письме верификации

        switchToWindow("Invite Friends"); //переключаемся на окно, не работает
        //open("http://www.4shared.com/web/acc/invite"); //открываем третий шаг вручную

        $(byAttribute("data-element", "h25_01")).should(appear);
        $(byAttribute("data-element", "h25_01")).click();

        $("#accountPopupTitle").waitUntil(appear, 10000);
        $("#accountPopupTitle").shouldHave(text("Congratulations, you have been successfully registered!")); // Подтверждаем, что мы действительно зарегистрированы появлением попапа с предложением установки десктопа.

        open("https://www.4shared.com/web/account/settings");

        $("#deleteAccountButton").waitUntil(appear, 5000);
        $("#deleteAccountButton").click();
        $("#deletePassword").val("9");
        $(byAttribute("data-element", "d5")).click();
        $((".confirmPopupBlueButton")).click();

        $(".smartbox .big").waitUntil(appear, 5000);

    }
}
