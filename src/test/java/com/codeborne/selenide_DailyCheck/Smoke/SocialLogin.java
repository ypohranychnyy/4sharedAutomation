package com.codeborne.selenide_DailyCheck.Smoke;

import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

/**
 * Created by User on 08.04.2014.
 */
public class SocialLogin {

    @After
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Test

    public void FBLogin() {
        open("https://www.4shared.com"); // Открываем 4ш
        $(byAttribute("data-element", "4")).click();

        $("#email").waitUntil(Condition.appear, 15000);
        $("#email").val("fb2@deng.4shared.com"); // Добавить времени, 6сек
        $("#pass").val("5326776DR");
        $("#u_0_1").click(); // Логинимся в аккаунт ФБ

        $("#folderMenuContainer").waitUntil(Condition.appear, 15000); //в аккаунте ли мы?
    }

    @Test

    public void TwitterLogin() {
        open("https://www.4shared.com"); // Открываем 4ш
        $(byAttribute("data-element", "3")).click();

        $("#username_or_email").waitUntil(Condition.appear, 15000);
        $("#username_or_email").val("fb2@deng.4shared.com");
        $("#password").val("5326776DR");
        $("#allow").click(); // Логинимся в аккаунт твиттера

        $("#folderMenuContainer").waitUntil(Condition.appear, 15000);//в аккаунте ли мы?
    }

    @Test

    public void GoogleLogin() {
        open("https://www.4shared.com"); // Открываем 4ш
        $(byAttribute("data-element", "5")).click();

        $("#Email").waitUntil(Condition.appear, 15000);
        $("#Email").val("autologin4sh@gmail.com");
        $("#Passwd").val("5326776DR");
        $("#signIn").click(); // Логинимся в аккаунт гугла

        $("#folderMenuContainer").waitUntil(Condition.appear, 15000);//в аккаунте ли мы?

    }
}

