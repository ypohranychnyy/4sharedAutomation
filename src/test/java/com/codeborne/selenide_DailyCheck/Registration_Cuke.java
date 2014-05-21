package com.codeborne.selenide_DailyCheck;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class Registration_Cuke {

    @Given("^fake email site$")
    public void Fake_email_site() {
        open("http://www.fakeinbox.com/"); //Открываем сайт временной почты
    }

    @When("^User enter correct data into registration form$")

    public void User_enter_correct_data_into_registration_form()  {
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
    }

    @And("^he submit it$")
    public void He_submit_it() throws Throwable {
        $("#registrationSubmit").click();
    }

    @Then("^the second step of registration should appear$")
    public void the_second_step_of_registration_should_appear() throws Throwable {
        $("#resend").should(appear);
    }

    @And("^he have to verify his email$")
    public void he_have_to_verify_his_email()  {

        open("http://www.fakeinbox.com/");

        $(byAttribute("title", "Reload")).click();
        $(byText("Show")).waitUntil(appear, 240000);
        $(byText("Show")).click();
        $(withText("https://www.4shared.com/verifyEmail.jsp")).waitUntil(appear, 20000);
        $(withText("https://www.4shared.com/verifyEmail.jsp")).click(); //Кликаем на ссылку в письме верификации
        sleep(5000);
        //$(withText("https://www.4shared.com/verifyEmail.jsp")).should(disappear);
    }

    @And("^the third step of registration should appear$")
    public void  the_third_step_of_registration_should_appear() {
       // switchToWindow("Invite Friends");
       open("https://www.4shared.com/web/acc/invite"); //вручную открываем третий шаг
    }

    @And("^User enters account$")
    public void User_enters_account() {

        $(byAttribute("data-element", "h25_01")).should(appear);
        $(byAttribute("data-element", "h25_01")).click();
        $("#accountPopupTitle").waitUntil(appear, 10000);
        $("#accountPopupTitle").shouldHave(text("Congratulations, you have been successfully registered!")); // Подтверждаем, что мы действительно зарегистрированы появлением попапа с предложением установки десктопа.
    }

    @Then("^he delete his account$")
    public void he_delete_his_account()  {
        open("https://www.4shared.com/web/account/settings");

        $("#deleteAccountButton").waitUntil(appear, 5000);
        $("#deleteAccountButton").click();
        $("#deletePassword").val("9");
        $(byAttribute("data-element", "d5")).click();
        $((".confirmPopupBlueButton")).click();

        $(".smartbox .big").waitUntil(appear, 5000);
    }
}
