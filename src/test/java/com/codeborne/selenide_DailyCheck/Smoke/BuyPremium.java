package com.codeborne.selenide_DailyCheck.Smoke;

import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BuyPremium {

    @Test

    public void UserCanBuyPrem() {


        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();  //запускаем через прокси, чтобы обойти ограничение
        proxy.setHttpProxy("http://${login}:${password}@${proxy}:${port}");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        open("https://www.4shared.com"); //открываем 4shared
        $(byAttribute("data-element", "10.1")).click();
        $("#paymentOptions").should(appear);
        $("#ecomm_visa1m").should(appear); //проверяем наличие элементов на premium.jsp
        $("#ecomm_mc12m").should(appear); //проверяем наличие элементов на premium.jsp
        $("#ecomm_visa1m").click(); //кликаем на Виза/1месяц

        $("#loginfield").should(appear);
        $("#loginfield").val("s@deng.4shared.com");
        $("#passfield").val("1");
        $("#passfield").pressEnter(); // Авторизуемся
        $(".authLoginButton").should(disappear);

        $("#paymentPopup").should(appear);
        $("#closePopupButton").should(appear);
        $("#openPaymentGateway").click();

        $(".totalPrice").should(appear);
        $("#cardentry").should(appear);
        $(".proceedButton").shouldBe(visible);
        $(".proceedButton").shouldHave(value("Proceed with payment"));
    }
}

