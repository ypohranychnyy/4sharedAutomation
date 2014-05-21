package com.codeborne.selenide_DailyCheck.Smoke;


import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UploadFolder {

 @Test

    public void UserCanUploadFolder() { //только Хром

     System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe"); //Запуск из Хрома
     System.setProperty("browser", "chrome");

     open("https://www.4shared.com"); // Открываем 4ш
     $(".controls .llink").click(); //Жмем логин в хедере
     $(".headLoginDropdown").should(appear); //Ждем дропдаун
     $(".jsInputLogin").val("test3@deng.4shared.com");
     $(".jsInputPassword").val("1").pressEnter();

     //$("#arrowUpload").should(Condition.appear);
     //$("#arrowUpload").click();

     $("#upFolder").should(appear);

     //$(byAttribute("onchange","return uploadFolderMainMenuItemChanged(this);")).sendKeys("C:\\For_test\\test.log");
     //$(".buttonsBlock .last .fakefile").click();
     $(".buttonsBlock .last .fakefile").sendKeys("C:\\For_test\\test.log");


     $(byAttribute("onchange","return uploadFolderMainMenuItemChanged(this);")).waitUntil(appear, 1200000);

     //$(byAttribute("data-element", "fm-1.1")).should(appear);
     //$(byAttribute("data-element", "fm-1.1")).sendKeys("C:\\For_test\\TestFolder");

     //$("#dropdownUpload").should(appear);
     //$(byAttribute("name","tfff0")).click();
     //$("#tfid1").sendKeys("C:\\For_test\\TestFolder");
     //$(".dropdown .commandUploadFolder .gaClick").should(appear);
     //$(".dropdown .commandUploadFolder .gaClick").sendKeys("C:\\For_test\\TestFolder");


     //$(byText("TestFolder")).waitUntil(appear, 20000);
 }

}
