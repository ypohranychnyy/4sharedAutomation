package com.codeborne.selenide_DailyCheck;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.$;

public class Ads_Cuke {

    @Then("^there should be ads on search$")

    public void there_should_be_ads_on_serch()  {

        $("#epom-e5f2d2223dbc1e93f811522a1cd588bc").shouldBe(Condition.visible); //Поиск_реклама вверху
        $("#epom-fd563e494e35ff78c4de821ef0a68ff8").shouldBe(Condition.visible); //Поиск_реклама слева
        $("#epom-a1378394746861434abfbd1926166295").shouldBe(Condition.visible); //Поиск_реклама слева 2

    }

    @Then("^there should be ads$")
    public void there_should_be_ads() {

        $("#epom-7d90bf3701f99909eda4dfe8b7405fd7").shouldBe(Condition.visible); //D1-реклама вверху
        $("#epom-2c76c0f3500bab0da811562331e7af45").shouldBe(Condition.visible); //D1-реклама справа 1
        $("#epom-a58bf57e2de31592b6ba50ae01192264").shouldBe(Condition.visible); //D1-реклама справа 2
        $("#epom-20a2d68eba7d0bad0c8054bb6a4a0a52").shouldBe(Condition.visible); //D1-реклама внизу
    }
}
