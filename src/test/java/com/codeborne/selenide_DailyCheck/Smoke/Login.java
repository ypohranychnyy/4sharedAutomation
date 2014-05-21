package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class Login {

    @After
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Test

    public void UserCanLogin() {

        open("https://www.4shared.com"); // Открываем 4ш
        $(".controls .llink").should(appear);
        $(".controls .llink").click(); //Жмем логин в хедере
        $(".headLoginDropdown").should(appear); //Ждем дропдаун
        $(".jsInputLogin").val("test2@deng.4shared.com");
        $(".jsInputPassword").val("1").pressEnter(); //Логинимся

        $("#foldertree").should(Condition.appear); // попадаем в акк

    }
}

