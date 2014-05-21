package com.codeborne.selenide_DailyCheck.Smoke;

import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class ResetPass {

    @After
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Test

    public void UserCanResetPass() {

        open("https://www.4shared.com"); // Открываем 4ш

        $(byAttribute("data-element","h15")).click();
        $("#changeLang").click();
        $(byAttribute("data-element","h18-en")).click();
        $(byAttribute("data-element","h18-en")).should(Condition.disappear); //меняем язык

        $(".controls .llink").click(); //Жмем логин в хедере
        $(".headLoginDropdown").should(appear); //Ждем дропдаун
        $(".socialLogin .remindPassLink").click();

        $(".jsInputEmail").should(appear);
        $(".jsInputEmail").val("qwerty2@fakeinbox.com");
        $(byAttribute("data-element", "9")).click(); // вносим адрес для восстановления пароля

        open("http://www.fakeinbox.com/"); //Открываем сайт временной почты
        $(byAttribute("name", "setemailaddress")).should(appear);
        $(byAttribute("name", "setemailaddress")).val("qwerty2");
        $(byAttribute("name", "setemail")).click();
        $("#setemailform").waitUntil(disappear, 10000); //устанавливаем нужный мейл во временной почте
         refresh(); // рефреш из-за особенностей сайта почты

        $(byAttribute("title", "Reload")).click();
        $(byText("Show")).waitUntil(appear, 240000);
        $(byText("Show")).click();
        $(withText("https://www.4shared.com/renewPassword.jsp")).click(); //Кликаем на ссылку в письме

        switchToWindow("4shared.com - online file sharing and storage - Password reminder");

        $(byAttribute("name", "newPassword")).should(appear);
        $(byAttribute("name", "newPassword")).val("2");
        $(byAttribute("name", "newPassword2")).val("2"); //вводим новый пароль
        $(byAttribute("data-element", "9")).click(); //подтверждаем

        $("#tmenu").should(appear);
        $("#tmenu").shouldHave(text("Your password was changed successfully"));

        //добавить проверку - логин с новым паролем, удаление старого письма?
    }

}
