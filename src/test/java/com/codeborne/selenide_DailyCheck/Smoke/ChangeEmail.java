package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ChangeEmail {

    @Test

    public void UserCanChangeEmail() {

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
        $("#registrationSubmit").click(); //Регистрируемся

        $("#resend").should(appear); //второй шаг регистрации // Попадаем на шаг с верификацией

        open("http://www.fakeinbox.com/");
        $(byAttribute("title", "Reload")).click();
        $(byText("Show")).waitUntil(appear, 240000);
        $(byText("Show")).click();
        $(withText("https://www.4shared.com/verifyEmail.jsp")).click(); //Кликаем на ссылку в письме верификации

        open("http://www.4shared.com/web/acc/invite");

        open("http://www.4shared.com/account/home.jsp");
        $("#accountPopupTitle").waitUntil(appear, 10000);
        //$("#accountPopupTitle").shouldHave(text("Congratulations, you have been successfully registered!")); // Подтверждаем, что мы действительно зарегистрированы появлением попапа с предложением установки десктопа.
        $(".close.jsClose").click(); //закрываем попап

        $("#foldertree").should(Condition.appear); // попадаем в акк


        open("http://en.getairmail.com/"); //Открываем сайт временной почты
        $("#start_here").click(); //
        $("#tempemail").click();
       //$("#tempemail").sendKeys(Keys.chord(Keys.CONTROL,"c"));
        String email2 = $("#tempemail").val();

        open("https://www.4shared.com");
        $(".gaClick .absmid").click();
        $(byAttribute("data-element", "h26")).click(); //переходим в акк

        $("#foldertree").should(Condition.appear); ////переход в акк
        $(".gear.piclink.sprite1.gaClick>i").should(Condition.appear);
        $(".gear.piclink.sprite1.gaClick>i").click(); // вызываем попап настроек
        $("#changeLang").should(Condition.appear); // попан настроек
        $(byAttribute("href", "/web/account/settings")).click(); // кликаем на сетинги

        $("#settingsNavigation").should(Condition.appear); // попали в настройки
        $("#accountSettingsOverviewForm").should(appear);
        $(".required.email").should(appear);
        $(".required.email").val(email2);

        $(".saveChangesButton").click(); // меняем мыло

        $("#accountPopupTitle").should(appear); // попап подтверждение
        $(byAttribute("name", "emailPasswordConfirm")).val("9"); //пароль
        $(byText("OK")).click(); //подтверждаем

        $("#tformVerify").should(appear); // страница верификации
        $(byAttribute("href", "/web/acc/changeemailForUnverifiedUser")).click(); // кликаем изменить имейл

        $("#stepEdit").should(appear);
        //$("#newEmail").sendKeys(Keys.chord(Keys.CONTROL, "v"));
        $("#newEmail").val(email);
        $(byValue("Save changes")).click();

        $("#tformVerify").should(appear); // страница верификации

        open("http://www.fakeinbox.com/");

        $(byAttribute("title","Reload")).click();
        $(byText("Show")).waitUntil(appear, 24000);
        $(byText("Show")).click();
        $(withText("https://www.4shared.com/verifyEmail.jsp")).click(); //Кликаем на ссылку в письме верификации

        open("http://www.4shared.com/web/acc/invite");

        open("http://www.4shared.com/account/home.jsp");
    }
}
