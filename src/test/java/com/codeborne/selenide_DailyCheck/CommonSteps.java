package com.codeborne.selenide_DailyCheck;


import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class CommonSteps {


    @After("@All")
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Given("^User go to 4shared$")
    public void user_go_to_shared() {
        open("https://www.4shared.com");
    }

    @But("^We need to delete that file$")
    public void We_need_to_delete_it()  {


        $(byAttribute("data-element","fm-4.4")).should(appear); //Появляется кнопка "Delete"
        $(byAttribute("data-element","fm-4.4")).click(); //Жмем удалить
        $((".confirmPopupBlueButton ")).click(); //Подтверждаем удаление
        $(byAttribute("data-element","viewL-tr")).waitUntil(disappear, 10000);
    }

    @And("^User logs in from main with correct credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void User_logs_in_with_correct_and(String login, String password){

            $(".controls .llink").click(); //Жмем логин в хедере
            $(".headLoginDropdown").should(appear); //Ждем дропдаун
            $(".jsInputLogin").val(login);
            $(".jsInputPassword").val(password).pressEnter(); //Логинимся
            $("#foldertree").waitUntil(appear, 10000);
    }

    @And("^User logs in from div with correct credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void User_logs_in_from_div_with_correct_credentials_and(String login, String password)  {
        $("#loginfield").should(appear);
        $("#loginfield").val(login);
        $("#passfield").val(password);
        $(".authLoginButton").click(); // Авторизуемся
        $(".authLoginButton").should(disappear);
    }
}


