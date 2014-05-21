package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class LoginAfterAnonUpload {

    @After
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Test

    public void UsercCanLoginAfterAnonUpload () {

        open("https://www.4shared.com"); // Открываем 4ш
        $(byText("Перетащите файлы сюда, чтобы")).should(Condition.appear); //изменить
        $("#fid0").sendKeys("C:\\For_test\\test.log");
        $("#tmenu").waitUntil(Condition.appear, 10000); //аплоадим файл на главной

        $(".input-gray-big.wide.round4.jsInputLogin").val("test3@deng.4shared.com"); //логинимся
        $(".input-gray-big.wide.round4.jsInputPassword").val("1");
        $(byAttribute("data-element", "9")).click();

        $("#foldertree").should(Condition.appear); //попадаем в акк
        $(byText("test.log")).shouldBe(present); //проверяем есть ли файл

        $(".checkFiles.jsCheckAll").click(); //Жмем чекбокс "Выделить все"
        $(byAttribute("data-element","fm-4.4")).should(appear); //Появляется кнопка "Delete"
        $(byAttribute("data-element","fm-4.4")).click(); //Жмем удалить
        $((".confirmPopupBlueButton ")).click(); //Подтверждаем удаление
        $(byAttribute("data-element","viewL-tr")).waitUntil(disappear, 10000);
    }

}
