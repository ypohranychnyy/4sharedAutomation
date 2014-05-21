package com.codeborne.selenide_DailyCheck;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class Upload_Cuke {

    @When("^he uploads some file$")
    public void he_uploads_some_file() {

        $("#tfid1").sendKeys("/usr/hosting/test.log");
    }

    @Then("^the file should be present in account$")
    public void the_file_should_be_present_in_account()  {

        $(byText("test.log")).waitUntil(appear, 20000); //Проверяем, что аплоад прошел ок
        $(".commandDetailsView").click(); // переключаемся на детальный вид
        $(byAttribute("name","ch_f")).waitUntil(appear, 10000);
        $(byText("test.log")).waitUntil(appear, 20000);
        $(".checkFiles.jsCheckAll").click(); //Жмем чекбокс

    }

}
