package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static junit.framework.TestCase.assertTrue;

public class Common {

    @Test

    @Before
    public void StartThisSession() {
        clearBrowserCache();
    }

    @Test

    public void HomePageLayoutAnonUser() {

        open("https://www.4shared.com"); // Открываем 4ш

        $("#searchQuery").should(appear); // строка поиска, подтверждаем переход
        $(".file.gaClick.clicked").should(appear); // категория Файлы
        $(".video.gaClick").should(appear); // категория Видео
        $(".music.gaClick").should(appear); // категория Музыка
        $(".photo.gaClick").should(appear); // категория Фото
        $(".book.gaClick").should(appear); // категория Книги
        $(".games.gaClick").should(appear); // категория Игры
        $(".archives.gaClick").should(appear); // категория Архивы

        $(".controls .llink").should(appear); //кнопка Логин
        $(byAttribute("data-element", "3")).should(appear); // twitter
        $(byAttribute("data-element", "4")).should(appear); // fb
        $(byAttribute("data-element", "5")).should(appear); // G+

        $("#sign_form_log").should(appear); // поле мыло
        $("#sign_form_cp1").should(appear); // пароль
        $("#sign_form_cp2").should(appear); // подтверждение пароля
        $(byAttribute("data-element", "9")).should(appear); // кнопка регистрация

        $(byAttribute("data-element", "10.1")).should(appear); // кнопка Premium
        $(byAttribute("data-element", "10.2")).should(appear); // картинка Premium
        $(byAttribute("data-element", "11.1")).should(appear); // кнопка Developer
        $(byAttribute("data-element", "11.2")).should(appear); // картинка Developer
        $(byAttribute("data-element", "12.1")).should(appear); // кнопка Mobile
        $(byAttribute("data-element", "12.2")).should(appear); // картинка Mobile
        $(byAttribute("data-element", "13.1")).should(appear); // кнопка Desktop
        $(byAttribute("data-element", "13.2")).should(appear); // картинка Desktop

        $(byAttribute("data-element", "19.1")).should(appear); // кнопка G+ в футере
        $(".item.tw.floatLeft.gaClick").should(appear); // кнопка twitter в футере
        $(".item.fb.floatLeft.gaClick").should(appear); // кнопка fb в футере
        $(".item.gplus.floatLeft.gaClick").should(appear); // кнопка G+ в футере
    }

    @Test

    public void HomePageLayoutLoggedUser() {

        open("https://www.4shared.com"); // Открываем 4ш
        $(".controls .llink").should(appear);
        $(".controls .llink").click(); //Жмем логин в хедере
        $(".headLoginDropdown").should(appear); //Ждем дропдаун
        $(".jsInputLogin").val("test1@deng.4shared.com");
        $(".jsInputPassword").val("1").pressEnter();  // логиминся
        $("#foldertree").should(Condition.appear); // попадаем в акк

        $(".floatLeft.logo.gaClick>a>img").click(); // жмем на лого для перехода на главную

        $("#searchQuery").should(appear); // строка поиска, подтверждаем переход
        $(".file.gaClick.clicked").should(appear); // категория Файлы
        $(".video.gaClick").should(appear); // категория Видео
        $(".music.gaClick").should(appear); // категория Музыка
        $(".photo.gaClick").should(appear); // категория Фото
        $(".book.gaClick").should(appear); // категория Книги
        $(".games.gaClick").should(appear); // категория Игры
        $(".archives.gaClick").should(appear); // категория Архивы

        $(".userpic.sprite1.marginLR5.absmid").should(appear); //Аватарка
        $(byAttribute("data-element", "h25_01")).should(appear); //Юзернейм

        $(byAttribute("data-element", "3")).shouldNot(appear); // не должно быть, twitter
        $(byAttribute("data-element", "4")).shouldNot(appear); // не должно быть, fb
        $(byAttribute("data-element", "5")).shouldNot(appear); // не должно быть, G+

        $("#sign_form_log").shouldNot(appear); // не должно быть, поле мыло
        $("#sign_form_cp1").shouldNot(appear); // не должно быть, пароль
        $("#sign_form_cp2").shouldNot(appear); // не должно быть, подтверждение пароля
        $(byAttribute("data-element", "9")).shouldNot(appear); // не должно быть, кнопка регистрация

        $(byAttribute("data-element", "10.1")).should(appear); // кнопка Premium
        $(byAttribute("data-element", "10.2")).should(appear); // картинка Premium
        $(byAttribute("data-element", "11.1")).should(appear); // кнопка Developer
        $(byAttribute("data-element", "11.2")).should(appear); // картинка Developer
        $(byAttribute("data-element", "12.1")).should(appear); // кнопка Mobile
        $(byAttribute("data-element", "12.2")).should(appear); // картинка Mobile
        $(byAttribute("data-element", "13.1")).should(appear); // кнопка Desktop
        $(byAttribute("data-element", "13.2")).should(appear); // картинка Desktop

        $(byAttribute("data-element", "19.1")).should(appear); // кнопка G+ в футере
        $(".item.tw.floatLeft.gaClick").should(appear); // кнопка twitter в футере
        $(".item.fb.floatLeft.gaClick").should(appear); // кнопка fb в футере
        $(".item.gplus.floatLeft.gaClick").should(appear); // кнопка G+ в футере
    }

    @Test

    public void HomePageLayoutNotVefifiedUser() {

        open("http://www.fakeinbox.com/"); //Открываем сайт временной почты

        //запускаем через прокси, чтобы обойти ограничение
        org.openqa.selenium.Proxy proxy = new Proxy();
        proxy.setProxyType(Proxy.ProxyType.AUTODETECT);

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PROXY, proxy);

        $(".t12l_get_email_button>input").should(appear);
        $(".t12l_get_email_button>input").click();
        $(".t12l_address_input").should(appear);
        $(".t12l_address_input").click();
        String email = $(".t12l_address_input").val();

        open("https://www.4shared.com");
        $(".rbox .button-orange").waitUntil(appear, 5000);
        $(".rbox .button-orange").pressEnter();
        $("#step1Regloginfield").val(email);
        $("#step1Regpassfield").val("9");
        $("#step1Regpassfield2").val("9");
        $("#step1firstname").val("9");
        $("#step1lastname").val("9");
        $("#registrationSubmit").click(); //Регистрируемся

        $("#resend").should(appear); // Попадаем на шаг с верификацией
        $(".downDesktopButton.alignCenter.round4").should(appear); // Попадаем на шаг с верификацией, кнопка

        $(".floatLeft.logo.gaClick>a>img").click(); // жмем на лого для перехода на главную

        $("#verifyAlertODiv").should(appear); // див о необходимости верификации в хедере
        $(".link-blue.ffshadow.no-line.marginR20>b").should(appear); // три кнопки - ресенд, изменить мыло и изучить

        $("#searchQuery").should(appear); // строка поиска
        $(".file.gaClick.clicked").should(appear); // категория Файлы
        $(".video.gaClick").should(appear); // категория Видео
        $(".music.gaClick").should(appear); // категория Музыка
        $(".photo.gaClick").should(appear); // категория Фото
        $(".book.gaClick").should(appear); // категория Книги
        $(".games.gaClick").should(appear); // категория Игры
        $(".archives.gaClick").should(appear); // категория Архивы


        $(".userpic.sprite1.marginLR5.absmid").should(appear); //Аватарка
        $(byAttribute("data-element", "h25_01")).should(appear); //Юзернейм

        $(byAttribute("data-element", "3")).shouldNot(appear); // не должно быть, twitter
        $(byAttribute("data-element", "4")).shouldNot(appear); // не должно быть, fb
        $(byAttribute("data-element", "5")).shouldNot(appear); // не должно быть, G+

        $("#sign_form_log").shouldNot(appear); // не должно быть, поле мыло
        $("#sign_form_cp1").shouldNot(appear); // не должно быть, пароль
        $("#sign_form_cp2").shouldNot(appear); // не должно быть, подтверждение пароля
        $(byAttribute("data-element", "9")).shouldNot(appear); // не должно быть, кнопка регистрация

        $(byAttribute("data-element", "10.1")).should(appear); // кнопка Premium
        $(byAttribute("data-element", "10.2")).should(appear); // картинка Premium
        $(byAttribute("data-element", "11.1")).should(appear); // кнопка Developer
        $(byAttribute("data-element", "11.2")).should(appear); // картинка Developer
        $(byAttribute("data-element", "12.1")).should(appear); // кнопка Mobile
        $(byAttribute("data-element", "12.2")).should(appear); // картинка Mobile
        $(byAttribute("data-element", "13.1")).should(appear); // кнопка Desktop
        $(byAttribute("data-element", "13.2")).should(appear); // картинка Desktop

        $(byAttribute("data-element", "19.1")).should(appear); // кнопка G+ в футере
        $(".item.tw.floatLeft.gaClick").should(appear); // кнопка twitter в футере
        $(".item.fb.floatLeft.gaClick").should(appear); // кнопка fb в футере
        $(".item.gplus.floatLeft.gaClick").should(appear); // кнопка G+ в футере

        $(byAttribute("data-element", "10.1")).click(); // переход на Premium
        $("#verifyAlertODiv").should(appear); // подтверждаем, что верификационный див есть

        $(".floatLeft.logo.gaClick>a>img").click(); // жмем на лого для перехода на главную
        $(byAttribute("data-element", "11.1")).click(); // кнопка Developer
        $("#verifyAlertODiv").should(appear); // подтверждаем, что верификационный див есть

        $(".floatLeft.logo.gaClick>a>img").click(); // жмем на лого для перехода на главную
        $(byAttribute("data-element", "12.1")).click(); // кнопка Mobile
        $("#verifyAlertODiv").should(appear); // подтверждаем, что верификационный див есть

        $(".floatLeft.logo.gaClick>a>img").click(); // жмем на лого для перехода на главную
        $(byAttribute("data-element", "13.1")).click(); // кнопка Desktop
        $("#verifyAlertODiv").should(appear); // подтверждаем, что верификационный див есть

        open("http://www.4shared.com/web/acc/verifyemail");
        $("#deleteAccountButton").should(appear);
        $("#deleteAccountButton").click();
        $("#deletePassword").should(appear);
        $("#deletePassword").val("9");
        $(byAttribute("data-element", "d5")).click();
        $((".confirmPopupBlueButton")).click(); //удаляем акк

        $(".smartbox .big").waitUntil(appear, 10000);

    }

    @Test

    public void UserCanReachFeaturesPage() {

        open("https://www.4shared.com"); // Открываем 4ш

        $(byAttribute("data-element", "f3")).should(appear);
        $(byAttribute("data-element", "f3")).click(); //кликаем features

        $(".floatLeft.lls").should(appear);
        $(".roundedFirst>div>p").should(appear);
        $(".roundedSecond>div>p").should(appear);
        $(".roundedThird>div>p").should(appear); // хедер таблицы
        $("#d1").should(appear);
        $("#d56").should(appear); //таблица

        $(".firstBottom").should(appear); //футер табл
        $(".roundedBtn1.floatLeft>div").should(appear); // кнопка Бай нау
        $(".thirdBottom").should(appear);

        $(".footer").should(appear); //футер страницы
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

        assertTrue(file.isFile()); //проверяем, что файл существует

        try {
            File fileToDelete = new File("D:\\4shared\\4sharedAutomation\\build\\reports\\tests\\desktop_5.0.rar"); //удаляем файл

            if (fileToDelete.delete()) {
                System.out.println("File deleted successfully!");
            } else {
                System.out.println("File delete operation failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();

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
