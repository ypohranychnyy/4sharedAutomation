package com.codeborne.selenide_DailyCheck;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by User on 30.04.2014.
 */
public class AddToMyAcc_Cuke {

    @When("^he clicks on 'Add to my account' button$")

    public void he_clicks_on_Add_to_my_account_button()  {
        $(byAttribute("data-element", "20")).should(appear);
        $(byAttribute("data-element", "20")).click();
        sleep(5000);
    }

    @Then("^green notification appears$")
    public void green_notification_appears() throws Throwable {
        $((".server-info .notify-msg")).waitUntil(Condition.appear, 10000); //Ждем появления зеленого хинта в хедере
        $(".gaClick .absmid").click();
        $(byAttribute("data-element", "h26")).click();
    }

    @And("^file is added to account$")
    public void file_is_added_to_account() {

        $(byAttribute("data-element", "viewT-tr")).shouldBe(present);

    }
}
