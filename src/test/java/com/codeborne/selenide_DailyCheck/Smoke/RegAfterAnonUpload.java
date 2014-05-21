package com.codeborne.selenide_DailyCheck.Smoke;

import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class RegAfterAnonUpload {

    @After
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Test

    public void UserCanRegAfterAnonUpl() throws InterruptedException {

        open("http://www.fakeinbox.com/"); //Открываем сайт временной почты
        $(byAttribute("name", "getemail")).click();
        $(".t12l_address_input").click();
        String email = $(".t12l_address_input").val();

        open("https://www.4shared.com"); // Открываем 4ш
        $(byText("Перетащите файлы сюда, чтобы")).should(Condition.appear);
        $("#fid0").sendKeys("C:\\For_test\\test.log");
        $("#tmenu").waitUntil(Condition.appear, 10000);
        $(".signupSuggestion .no-line").pressEnter();

        $("#step1Regloginfield").should(Condition.appear);
        $("#step1Regloginfield").val(email);
        $("#step1Regpassfield").val("9");
        $("#step1Regpassfield2").val("9");
        $("#step1firstname").val("9");
        $("#step1lastname").val("9");
        $("#registrationSubmit").click(); //Регистрируемся

        $("#resend").should(appear); //второй шаг регистрации

        open("http://www.fakeinbox.com/");

        $(byAttribute("title", "Reload")).click();
        $(byText("Show")).waitUntil(appear, 240000);
        $(byText("Show")).click();
        $(withText("https://www.4shared.com/verifyEmail.jsp")).click(); //Кликаем на ссылку в письме верификации

        open("http://www.4shared.com/web/acc/invite");
        //$(byAttribute("data-element", "h25_01")).should(appear);
        //$(byAttribute("data-element", "h25_01")).click(); // Переходим в акк
        open("http://www.4shared.com/account/home.jsp");
        $("#accountPopupTitle").waitUntil(appear, 10000);
        $("#accountPopupTitle").shouldHave(text("Congratulations, you have been successfully registered!"));
        $(".ii .hh .jsClose").click(); //закрываем попап

        $(byText("test.log")).shouldBe(present);

        open("https://www.4shared.com/web/account/settings");

        $("#deleteAccountButton").waitUntil(appear, 5000);
        $("#deleteAccountButton").click();
        $("#deletePassword").val("9");
        $(byAttribute("data-element", "d5")).click();
        $((".confirmPopupBlueButton")).click();

        $(".smartbox .big").waitUntil(appear, 5000);

    }
}
