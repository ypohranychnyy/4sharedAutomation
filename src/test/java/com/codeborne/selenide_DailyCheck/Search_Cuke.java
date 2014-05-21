package com.codeborne.selenide_DailyCheck;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class Search_Cuke {

    @When("^User go to search page$")
    public void User_go_to_search_page()  {

        $(".lbox .proceed ").should(Condition.appear);
        $(".lbox .proceed ").click();
    }

    @Then("^there should be some results$")
    public void there_should_be_some_results()  {

        $("#s1").click(); //Сортируем по просмотрам(за все время), чтобы получить больше результатов
        $(byAttribute("data-element", "r1.3")).shouldBe(Condition.visible);
        $(byAttribute("data-element", "r10.3")).shouldBe(Condition.visible);
        $(By.id("total_q")).shouldNotHave(Condition.value("0")); //Проверяем, что количество результатов не равно "0"
    }


    @And("^he searches for the \"([^\"]*)\" file$")
    public void he_searchs_for_the_file(String request) {

        $("#searchQueryNew").setValue(request).pressEnter();

    }

    @When("^he found what he wants$")
    public void he_found_what_he_wants()  {

        $(byAttribute("href","http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm")).should(Condition.appear);
    }

}
