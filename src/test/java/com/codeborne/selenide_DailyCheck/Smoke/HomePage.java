package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import cucumber.api.java.Before;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class HomePage {

    @Before
    public void EndThisSession() {
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
}