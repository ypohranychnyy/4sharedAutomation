package com.codeborne.selenide_DailyCheck;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SocialDownload_Cuke {

    @Then("^he go to D-one page of some file$")
    public void he_go_to_D_one_page_of_this_file() {
        open("http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm");
    }

    @And("^he press Download button on D-one$")
    public void he_press_Download_button_on_D_one()  {

        $("#btnLink").click(); //D1 - кликаем Скачать
    }

    @When("^he goes to D-two$")
    public void he_goes_to_D_two_and_press_Free_Download_there()  {
        $(".freeDownloadButton").should(Condition.appear);
    }

    @And("^press Free Download there$")
    public void press_Free_Download_there() {

        $(".freeDownloadButton").click();
    }

    @Then("^One-click download popup should appear$")
    public void One_click_download_popup_should_appear()  {
        $(byAttribute("data-element","LoginFacebook")).should(Condition.appear);
    }

    @And("^he clicks on fb button$")
    public void he_click_fb_button()  {
        $(byAttribute("data-element","LoginFacebook")).click();
    }

    @And("^he login to fb$")

    public void he_login_to_fb() {
        $("#email").waitUntil(Condition.appear,15000);
        $("#email").val("fb@deng.4shared.com");
        $("#pass").val("5326776DR");
        $("#u_0_1").click(); // Логинимся в аккаунт ФБ
    }

    @When("^the timer stops counting$")
    public void the_timer_stops_counting()  {
        $("#downloadDelayTimeSec").waitUntil(Condition.disappear,30000); //
    }

    @Then("^the file starts downloading and user goes to D-three$")
    public void User_goes_to_D_three() throws Throwable {
        $(".floatLeft.finfo.lucida.ffshadow.paddingL15").shouldBe(Condition.visible); //D3 - Проверяем попали ли мы на D3
        $(".db .premium").shouldBe(Condition.visible);
    }


}
