package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InfectedFileIsMarkedRed {

    @Test
    public void InfectedFileIsMarkedRed(){

        open("http://www.4shared.com/zip/C2W4bofzce/eicar_com.html?"); // this file is infected
        $(".antivirusBanner .marginT5").shouldBe(Condition.visible);//Asserting that file with virus is marked red (MacCaffee)
        $("#btnLink").click(); //D1 - Click download button
        $(".p_window").waitUntil(Condition.appear, 5000); //notification about virus appears
        $(".jsClose").click(); //закрываем попап
    }

}
