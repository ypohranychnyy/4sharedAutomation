package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class PremiumFeatures {

    @Before
    public void StartThisSession() {
        clearBrowserCache();
    }

    @Test

    public void NoAdsIsPresent_NoD2() {

        open("https://www.4shared.com"); // Открываем 4ш

        $(".controls .llink").click(); //Жмем логин в хедере
        $(".headLoginDropdown").should(appear); //Ждем дропдаун
        $(".jsInputLogin").val("test4@deng.4shared.com");
        $(".jsInputPassword").val("1").pressEnter();
        $("#foldertree").should(Condition.appear);

        open("https://www.4shared.com"); // Открываем 4ш

        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска

        $("#epom-e5f2d2223dbc1e93f811522a1cd588bc").shouldNotBe(Condition.visible); //Поиск_реклама вверху
        $("#epom-fd563e494e35ff78c4de821ef0a68ff8").shouldNotBe(Condition.visible); //Поиск_реклама слева
        $("#epom-a1378394746861434abfbd1926166295").shouldNotBe(Condition.visible); //Поиск_реклама слева 2

        open("http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm"); //вручную открываем ссылку с единственным результатом

        $("#epom-7d90bf3701f99909eda4dfe8b7405fd7").shouldNotBe(Condition.visible); //D1-реклама вверху
        $("#epom-2c76c0f3500bab0da811562331e7af45").shouldNotBe(Condition.visible); //D1-реклама справа 1
        $("#epom-a58bf57e2de31592b6ba50ae01192264").shouldNotBe(Condition.visible); //D1-реклама справа 2
        $("#epom-20a2d68eba7d0bad0c8054bb6a4a0a52").shouldNotBe(Condition.visible); //D1-реклама внизу

        $("#btnLink").click(); //D1 - кликаем Скачать
        $("#mp3player_wrapper").shouldNot(disappear);

    }

    @Test
    public void Zip(){

        open("https://www.4shared.com"); // Открываем 4ш

        $(".controls .llink").click(); //Жмем логин в хедере
        $(".headLoginDropdown").should(appear); //Ждем дропдаун
        $(".jsInputLogin").val("test4@deng.4shared.com");
        $(".jsInputPassword").val("1").pressEnter();
        $("#foldertree").should(Condition.appear);

        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска
        $(byAttribute("data-element", "20")).click(); // нажимаем Add to my acc

        $((".server-info .notify-msg")).waitUntil(Condition.appears,6000); //Ждем появления зеленого хинта в хедере
        $(".gaClick .absmid").click();
        $(byAttribute("data-element", "h26")).click(); //переходим в акк

        $(byAttribute("data-element","fm-m")).waitUntil(appears, 10000);
        $(byAttribute("data-element","fm-m")).click(); //жмем More

        $(byAttribute("data-element","fM-6")).waitUntil(appears, 10000);
        $(byAttribute("data-element","fM-6")).click(); //жмем ZIP

        $("#accountPopupTitle").should(Condition.appear);
        $(byAttribute("name","bgAction")).click(); //жмем Сreate в Зип попапе

        $("#accountPopupTitle").should(Condition.appear); // появляется Бэкграунд таск попап
        $(".confirmPopupBlueButton").click(); // жмем Done

        $(byAttribute("data-element", "h25_01")).shouldBe(present); // торможу тесты
        $(byAttribute("data-element", "h25_01")).click(); // рефрешу акк
        $("#foldertree").should(Condition.appear);

        $(".commandDetailsView").click(); // переключаемся на детальный вид

        $(byAttribute("data-element", "h25_01")).shouldBe(present); // торможу тесты
        $(byAttribute("data-element", "h25_01")).click();

        $(".commandDetailsView").click(); // переключаемся на детальный вид

        $(byText("My 4shared.zip")).waitUntil(appear, 10000); //проверяем наличие зипа
        $(byAttribute("file-size", "2688390")).shouldBe(present); //проверяем, что зип не 0; переделать, вероятность падения
        //$(".TfilesSize.f11").shouldHave(text("2.6 MB"));

        $(".checkFiles.jsCheckAll").click();
        $(byAttribute("data-element","fm-4.4")).should(appear); //Появляется кнопка "Delete"
        $(byAttribute("data-element","fm-4.4")).click(); //Жмем удалить
        $((".confirmPopupBlueButton ")).click(); //Подтверждаем удаление
        $(byAttribute("data-element","viewL-tr")).waitUntil(disappear, 10000);

    }

}
