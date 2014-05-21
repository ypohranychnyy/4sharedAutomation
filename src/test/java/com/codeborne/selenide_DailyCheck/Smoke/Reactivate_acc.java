package com.codeborne.selenide_DailyCheck.Smoke;

import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by User on 15.04.2014.
 */
public class Reactivate_acc {

    @Test

    public void UserCanDeleteAndReactivateAcc() {

        open("http://www.fakeinbox.com/"); //Открываем сайт временной почты
        $(byAttribute("name", "getemail")).click();
        $(".t12l_address_input").click();
        String email = $(".t12l_address_input").val();

        open("https://www.4shared.com");
        $(".rbox .button-orange").waitUntil(appear, 5000);
        $(".rbox .button-orange").click();
        $("#step1Regloginfield").val(email);
        $("#step1Regpassfield").val("9");
        $("#step1Regpassfield2").val("9");
        $("#step1firstname").val("9");
        $("#step1lastname").val("9");
        $("#registrationSubmit").click(); //Регистрируемся

        $("#resend").shouldHave(text("Письмо с инструкциями")); // Попадаем на шаг с верификацией

        open("http://www.fakeinbox.com/");

        $(byAttribute("title", "Reload")).click();
        $(byText("Show")).waitUntil(appear, 240000);
        $(byText("Show")).click();
        $(withText("https://www.4shared.com/verifyEmail.jsp")).click(); //Кликаем на ссылку в письме верификации


        open("http://www.4shared.com/web/acc/invite");

        open("http://www.4shared.com/account/home.jsp");
        $("#accountPopupTitle").waitUntil(appear, 10000);
        $("#accountPopupTitle").shouldHave(text("Congratulations, you have been successfully registered!")); // Подтверждаем, что мы действительно зарегистрированы появлением попапа с предложением установки десктопа.

        open("https://www.4shared.com/web/account/settings");

        $("#deleteAccountButton").waitUntil(appear, 5000);
        $("#deleteAccountButton").click();
        $("#deletePassword").should(appear);
        $("#deletePassword").val("9");
        $(byAttribute("data-element", "d5")).click();
        $((".confirmPopupBlueButton")).click();

        $(".smartbox .big").waitUntil(appear, 5000);
    }
}
