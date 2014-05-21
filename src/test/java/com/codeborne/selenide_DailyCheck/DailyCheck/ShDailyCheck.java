package com.codeborne.selenide_DailyCheck.DailyCheck;


import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class ShDailyCheck {

    @Category(ShDailyCheck.class)

    @After
    public void EndThisSession() {
        clearBrowserCache();
    }

    @Test

    public void Ads_is_present() {
        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска

        $("#epom-e5f2d2223dbc1e93f811522a1cd588bc").shouldBe(Condition.visible); //Поиск_реклама вверху
        $("#epom-fd563e494e35ff78c4de821ef0a68ff8").shouldBe(Condition.visible); //Поиск_реклама слева
        $("#epom-a1378394746861434abfbd1926166295").shouldBe(Condition.visible); //Поиск_реклама слева 2

        $(byAttribute("data-element", "r1.3")).shouldBe(Condition.visible);// нажимаем на единственный результат поиска; через этот шаг не выходит
        open("http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm"); //вручную открываем ссылку с единственным результатом

        $("#epom-7d90bf3701f99909eda4dfe8b7405fd7").shouldBe(Condition.visible); //D1-реклама вверху
        $("#epom-2c76c0f3500bab0da811562331e7af45").shouldBe(Condition.visible); //D1-реклама справа 1
        $("#epom-a58bf57e2de31592b6ba50ae01192264").shouldBe(Condition.visible); //D1-реклама справа 2
        $("#epom-20a2d68eba7d0bad0c8054bb6a4a0a52").shouldBe(Condition.visible); //D1-реклама внизу

        $("#btnLink").click(); //D1 - кликаем Скачать

        $("#epom-7d90bf3701f99909eda4dfe8b7405fd7").shouldBe(Condition.visible); //D2-реклама вверху
        $("#epom-2c76c0f3500bab0da811562331e7af45").shouldBe(Condition.visible); //D2-реклама справа 1
        $("#epom-a58bf57e2de31592b6ba50ae01192264").shouldBe(Condition.visible); //D2-реклама справа 2
        $("#epom-20a2d68eba7d0bad0c8054bb6a4a0a52").shouldBe(Condition.visible); //D2-реклама внизубую

        //$(".trinityDownload").click(); // D2 - кликаем Приоритетная загрузка

        //$(byText("Благодарим за скачивание файла")).waitUntil(Condition.appears, 25000); //D3 - Проверяем попали ли мы на D3
        //$("#epom-dd5cdd93521df2b437473ee356c6cca7").shouldBe(Condition.visible); //D3-реклама вверху
        //$("#epom-af30f9d9f8ab941dfb60a1b74d83b653").shouldBe(Condition.visible); //D3-реклама справа 1
        //$("#epom-afa5f2a217e193ca006103ff277d2a8c").shouldBe(Condition.visible); //D3-реклама справа 2
        //$("#epom-20a2d68eba7d0bad0c8054bb6a4a0a52").shouldBe(Condition.visible); //D3-реклама внизу

    }

    @Test
    public void UserCanSearch() {
        open("https://www.4shared.com"); //открываем 4shared

        $(byAttribute("data-element", "h15")).click();
        $("#changeLang").click();
        $(byAttribute("data-element", "h18-en")).click(); //меняем язык на англ, чтобы точно быть уверенными
        $(byAttribute("data-element", "h18-en")).should(Condition.disappear);

        $(".lbox .proceed ").should(Condition.appear);
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска

        $("#s1").click(); //Сортируем по просмотрам(за все время), чтобы получить больше результатов
        $(byAttribute("data-element", "r1.3")).shouldBe(Condition.visible);
        $(byAttribute("data-element", "r10.3")).shouldBe(Condition.visible); //Проверяем наличие первого и последнего результата на странице поиска
        $(By.id("total_q")).shouldNotHave(Condition.value("0")); //Проверяем, что количество результатов не равно "0"

        $("#s2").click(); //Сортируем по дате, чтобы проверить отсутствие пробелов
        $(byAttribute("data-element", "r1.3")).shouldBe(Condition.visible);
        $(byAttribute("data-element", "r10.3")).shouldBe(Condition.visible); //Проверяем наличие первого и последнего результата на странице поиска
        $(By.id("total_q")).shouldNotHave(Condition.value("0")); //Проверяем, что количество результатов не равно "0"
        $(".fdate").shouldHave(Condition.text("less than a minute ago")); //Проверяем, что файлы добавляются равномерно(отсутствие пробелов)
    }

    @Test
    public void UserCanUpload()  {  // Аккаунт должен быть пустой!!! Корзину чистить??
        open("https://www.4shared.com"); // Открываем 4ш
        $(".controls .llink").click(); //Жмем логин в хедере
        $(".headLoginDropdown").should(appear); //Ждем дропдаун
        $(".jsInputLogin").val("test2@deng.4shared.com");
        $(".jsInputPassword").val("1").pressEnter(); //Логинимся
        $("#foldertree").should(Condition.appear);

        $("#tfid1").sendKeys("C:\\For_test\\test.log"); //Аплоадим тестовый файл

        $(byText("test.log")).waitUntil(appear, 20000); //Проверяем, что аплоад прошел ок
        $(".commandDetailsView").click(); // переключаемся на детальный вид

        $(byAttribute("name","ch_f")).waitUntil(appear, 10000);
        $(byText("test.log")).waitUntil(appear, 10000);
        $(".checkFiles.jsCheckAll").click(); //Жмем чекбокс

        $(byAttribute("data-element","fm-4.4")).should(appear); //Появляется кнопка "Delete"
        $(byAttribute("data-element","fm-4.4")).click(); //Жмем удалить
        $((".confirmPopupBlueButton ")).click(); //Подтверждаем удаление
        $(byAttribute("data-element","viewL-tr")).waitUntil(disappear, 10000);

        $(byAttribute("data-element","h25")).click();
        $(byAttribute("data-element","h27")).click();
        $("#sign_form_log").waitUntil(appear, 10000);
    }


    @Test
    public void UserCanAddToMyAccount() {
        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска
        $(byAttribute("data-element", "20")).click(); // нажимаем Add to my acc, получаем авторизационный див

        sleep(5000);

        $("#loginfield").should(appear);
        $("#loginfield").val("Test1@deng.4shared.com");
        $("#passfield").val("1");
        $(".authLoginButton").click(); // Авторизуемся
        $(".authLoginButton").should(disappear);


        $((".server-info .notify-msg")).waitUntil(Condition.appear, 6000); //Ждем появления зеленого хинта в хедере
        $(".gaClick .absmid").click();

        $(byAttribute("data-element", "h26")).click();


        $(byAttribute("data-element", "fm-4.4")).waitUntil(appear, 10000); //Появляется кнопка "Delete"
        $(byAttribute("data-element", "fm-4.4")).click(); //Жмем удалить
        $(".confirmPopupBlueButton").click(); //Подтверждаем удаление
        $(byAttribute("data-element", "viewT-tr")).waitUntil(disappear, 10000);

        $(byAttribute("data-element", "h25")).click();
        $(byAttribute("data-element", "h27")).click();
        $("#sign_form_log").waitUntil(appear, 10000);
    }

    @Test

    public void UserCanRegister() {


        //System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        open("http://www.fakeinbox.com/"); //Открываем сайт временной почты
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

        $("#resend").waitUntil(appear, 15000);
        $("#resend").shouldHave(text("Письмо с инструкциями")); // Попадаем на шаг с верификацией

        open("http://www.fakeinbox.com/");


        $(byAttribute("title", "Reload")).click();
        $(byText("Show")).waitUntil(appear, 240000);
        $(byText("Show")).click();
        $(withText("https://www.4shared.com/verifyEmail.jsp")).click(); //Кликаем на ссылку в письме верификации

        open("http://www.4shared.com/web/acc/invite");
        //$(byAttribute("data-element", "h25_01")).should(appear);
        //$(byAttribute("data-element", "h25_01")).click(); // Переходим в акк
        open("http://www.4shared.com/account/home.jsp");
        $("#accountPopupTitle").waitUntil(appear, 10000);
        $("#accountPopupTitle").shouldHave(text("Congratulations, you have been successfully registered!")); // Подтверждаем, что мы действительно зарегистрированы появлением попапа с предложением установки десктопа.

        open("https://www.4shared.com/web/account/settings");

        $("#deleteAccountButton").waitUntil(appear, 5000);
        $("#deleteAccountButton").click();
        $("#deletePassword").val("9");
        $(byAttribute("data-element", "d5")).click();
        $((".confirmPopupBlueButton")).click();

        $(".smartbox .big").waitUntil(appear, 5000);
    }

    @Test
    public void UserCanDownload() {
        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();   //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска

        open("http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm"); //вручную открываем ссылку с единственным результатом

        $("#btnLink").click(); //D1 - кликаем Скачать

        $(".freeDownloadButton").click(); //D2 - кликаем Бесплатная загрузка
        $(byAttribute("data-element","LoginFacebook")).should(Condition.appear);
        $(byAttribute("data-element","LoginFacebook")).click(); // Social Download popup - выбираем ФБ

        $("#email").waitUntil(Condition.appear,15000);
        $("#email").val("fb@deng.4shared.com"); //
        $("#pass").val("5326776DR");
        $("#u_0_1").click(); // Логинимся в аккаунт ФБ

        $("#downloadDelayTimeSec").waitUntil(Condition.disappear,30000); // Ждем пока пропадет каунтер

        $(".floatLeft.finfo.lucida.ffshadow.paddingL15").shouldBe(Condition.visible); //D3 - Проверяем попали ли мы на D3
        $(".db .premium").shouldBe(Condition.visible);

    }

}
