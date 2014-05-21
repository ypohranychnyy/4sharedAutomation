package com.codeborne.selenide_DailyCheck.DailyCheck;


import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Upload {

    @Test
    public void UserCanUpload() {  // Аккаунт должен быть пустой!!! Корзину чистить??

        //System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        //System.setProperty("browser", "chrome");

        open("https://www.4shared.com"); // Открываем 4ш

        $(".controls .llink").click(); //Жмем логин в хедере
        $(".headLoginDropdown").should(appear); //Ждем дропдаун
        $(".jsInputLogin").val("test2@deng.4shared.com");
        $(".jsInputPassword").val("1").pressEnter(); //Логинимся
        $("#foldertree").should(Condition.appear);

        $("#tfid1").sendKeys("C:\\For_test\\test.log"); //Аплоадим тестовый файл

        $(byText("test.log")).waitUntil(appear, 10000); //Проверяем, что аплоад прошел ок
        $(".commandDetailsView").click(); // переключаемся на детальный вид
        $(byAttribute("name","ch_f")).waitUntil(appear, 10000);
        $(byText("test.log")).waitUntil(appear, 20000);
        $(".checkFiles.jsCheckAll").click(); //Жмем чекбокс

        $(byAttribute("data-element","fm-4.4")).should(appear); //Появляется кнопка "Delete"
        $(byAttribute("data-element","fm-4.4")).click(); //Жмем удалить
        $((".confirmPopupBlueButton ")).click(); //Подтверждаем удаление
        $(byAttribute("data-element","viewL-tr")).waitUntil(disappear, 10000);

        $(byAttribute("data-element","h25")).click();
        $(byAttribute("data-element","h27")).click();
        $("#sign_form_log").waitUntil(appear, 10000); //вылогиниваемся
    }
}
