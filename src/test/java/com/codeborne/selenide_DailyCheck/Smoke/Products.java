package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static junit.framework.TestCase.assertTrue;



public class Products {

    @After
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Test

    public void UserCanDownloadOurProducts() throws FileNotFoundException {

        open("https://www.4shared.com"); // Открываем 4ш
        $("#searchQuery").should(appear);

        $(byAttribute("data-element", "h15")).click();
        $("#changeLang").click();
        $(byAttribute("data-element", "h18-en")).click(); //меняем язык на англ, чтобы точно быть уверенными
        $(byAttribute("data-element", "h18-en")).should(Condition.disappear);


        $(byAttribute("data-element", "11.2")).should(appear);
        $(byAttribute("data-element", "11.2")).click(); //картинка Developer

        $(".promoHeader").should(appear);
        $(".inner-grad.tab-about").should(appear);
        $(".inner-grad.tab-gettingin").should(appear);
        $(".inner-grad.tab-bestapps").should(appear);
        $("#cont-about>h2").should(appear); // проверяем, что мы на Дев странице
        $(".footer").should(appear);

        open("https://www.4shared.com"); // Открываем 4ш
        $(byAttribute("data-element", "13.1")).should(appear); // кнопка Desktop
        $(byAttribute("data-element", "13.1")).click();
        $(".floatLeft.productDesc>img").should(appear);
        $(".fContainer2").should(appear);
        $("#page").should(appear);
        $("#dButton").should(appear);
        $(".footer").should(appear);
        //$("#dButton").download();


        open("https://www.4shared.com"); // Открываем 4ш
        $(byAttribute("data-element", "12.1")).should(appear); // кнопка Mobile
        $(byAttribute("data-element", "12.1")).click();
        $(".footer").should(appear);

        $(".android").should(appear);
        $(".iphone").should(appear);
        $(".ipad").should(appear);
        $(".blackberry").should(appear);
        $(".symbian").should(appear);
        $(".asha").should(appear);
        $(".footer").should(appear); //страница Mobile

        $(".android").click();
        $(".floatLeft.app_container").should(appear); //страница андроида
        $(".floatRight.app_container").should(appear);
        $(".bl-button.android-blue.gaClick>span").should(appear); //кнопка 4ш андроид
        $(".bl-button.android-blue.gaClick>span").should(appear); //кнопка 4ш музыка
        $(".footer").should(appear);

        $(byAttribute("data-element", "mb5")).click(); // кликаем в хедере для перехода на стр айфона
        $(".centered.teaser_content>div").should(appear); //страница айфона
        $(".appcat.floatLeft").should(appear); //страница айфона
        $(byAttribute("data-element", "mi5")).should(appear); //кнопка 4ш для айфона
        // $(byAttribute("data-element", "mi5")).click();
        // $(".left>h1").waitUntil(appear, 10000);
        //$(".left>h1").shouldHave(text("4shared Mobile")); //открытие айтюнса - справиться?
        $(byAttribute("data-element", "mi14")).should(appear); //кнопка 4ш фото для айфона
        $(".footer").should(appear);

        $(byAttribute("data-element", "mb3")).click(); // кликаем в хедере для перехода на стр блэкбери
        $(".floatLeft.app_container").should(appear); //страница блэкбери
        $(".blue-teaser .container").should(appear);
        $(".blue-teaser .container").shouldHave(text("4shared for your BlackBerry"));
        $("#download_now").should(appear); // кнопка скачать
        $("#download_now").download(); // скачиваем

        File file = new File("D:\\4shared\\4sharedAutomation\\build\\reports\\tests\\desktop_5.0.rar");
        boolean isFile = file.isFile();
        System.out.println("File " + file.getPath() + " isFile: " + isFile); //проверяем, что файл существует

        assertTrue(file.isFile());

        try {
            File fileToDelete = new File("D:\\4shared\\4sharedAutomation\\build\\reports\\tests\\desktop_5.0.rar"); //удаляем файл

            if (fileToDelete.delete()) {
                System.out.println("File deleted successfully!");
            } else {
                System.out.println("File delete operation failed!");
            }

        } catch (Exception e) {
            e.printStackTrace(); //удаляем скачанный файл

        }

        $(byAttribute("data-element", "mb3")).click(); // кликаем в хедере для перехода на стр аши
        $(".floatLeft.app_container.marginL45.paddingL50").should(appear);
        $(".floatLeft.app_container").should(appear); //страница аши
        $(".blue-teaser .container").should(appear);
        $(".blue-teaser .container").shouldHave(text("4shared Application for Nokia Full Touch"));
        $("#download_now").should(appear); // кнопка скачать 4ш
        $("#download_now").click();
        $("#logoOvi>a>span").should(appear); // попадаем в магазин приложений нокии
        $(".title.fn").should(appear);
        $(".title.fn").shouldHave(text("4shared"));

        open("https://www.4shared.com/m/asha.jsp"); // Открываем 4ш
        $(byAttribute("data-element", "ma14")).should(appear); // кнопка скачать 4ш music
        $(byAttribute("data-element", "ma14")).click();
        $("#logoOvi>a>span").should(appear); // попадаем в магазин приложений нокии
        $(".title.fn").should(appear);
        $(".title.fn").shouldHave(text("4shared Music"));
        }
    }

