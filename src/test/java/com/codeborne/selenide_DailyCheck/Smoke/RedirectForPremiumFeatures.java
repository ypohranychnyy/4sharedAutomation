package com.codeborne.selenide_DailyCheck.Smoke;


import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RedirectForPremiumFeatures {

    @Test

    public void RedirectForPremiumFeaturesIsPresent () {

        open("https://www.4shared.com"); // Открываем 4ш

        $(".controls .llink").should(appear);
        $(".controls .llink").click(); //Жмем логин в хедере
        $(".headLoginDropdown").should(appear); //Ждем дропдаун
        $(".jsInputLogin").val("test6@deng.4shared.com");
        $(".jsInputPassword").val("1").pressEnter(); //Логинимся

        $("#foldertree").should(Condition.appear); // попадаем в акк
        $(".gear.piclink.sprite1.gaClick>i").click(); //Жмем шестеренку
        $("#changeLang").click();
        $(byAttribute("data-element","h18-en")).click();
        $(byAttribute("data-element","h18-en")).should(Condition.disappear); //меняем язык

        $("#arrowUpload").click(); //вызываем дропдаун
        $(byAttribute("data-element", "fm-1.2p")).should(appear);
        $(byAttribute("data-element", "fm-1.2p")).click(); //ftp
        $("#accountPopupTitle").should(Condition.appear); // премиум попап
        $("#upgradeLink").should(Condition.appear); // премиум попап
        $("#premiumColumnSelect").should(Condition.appear); // премиум попап

        $("#tfid1").sendKeys("C:\\For_test\\test.log"); //Аплоадим тестовый файл
        $(byText("test.log")).waitUntil(appear, 20000); //Проверяем, что аплоад прошел ок
        $(".commandDetailsView").click(); // переключаемся на детальный вид
        $(byAttribute("name","ch_f")).waitUntil(appear, 10000);
        $(byText("test.log")).waitUntil(appear, 20000); // подтверждаем аплоад
        $(".checkFiles.jsCheckAll").click(); //Жмем чекбокс
        $(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i").should(appear); // ждем появления кнопки More
        $(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i").click(); // жмем кнопку More
        $(".jsFromFiles .dropdown").should(appear); //дропдаун
        $(byAttribute("data-element", "cM-6p")).click(); //жмем на Zip
        $("#accountPopupTitle").should(Condition.appear); // премиум попап
        $("#upgradeLink").should(Condition.appear); // премиум попап
        $("#premiumColumnSelect").should(Condition.appear); // премиум попап
        $(".ii .hh .jsClose").click(); //закрываем попап

        $(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i").should(appear); // ждем появления кнопки More
        $(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i").click(); // жмем кнопку More
        $(".jsFromFiles .dropdown").should(appear); //дропдаун
        $(byAttribute("data-element", "cM-3.3")).click(); // жмем Share
        $("#accountPopupTitle").should(Condition.appear); // появляется шеринг попап
        $("#directLink").should(Condition.appear);
        $("#directLink").click(); //жмем Директ линк
        $("#accountPopupTitle").should(Condition.appear); // премиум попап
        $("#upgradeLink").should(Condition.appear); // премиум попап
        $("#premiumColumnSelect").should(Condition.appear); // премиум попап
        $(".ii .hh .jsClose").click(); //закрываем премиум попап
        $("#closeShPopup").should(appear);
        $("#closeShPopup").click(); //закрываем шеринг попап

        $(byAttribute("data-element","fm-4.4")).should(appear); //Появляется кнопка "Delete"
        $(byAttribute("data-element","fm-4.4")).click(); //Жмем удалить
        $((".confirmPopupBlueButton ")).click(); //Подтверждаем удаление
        $(byAttribute("data-element","viewL-tr")).waitUntil(disappear, 10000);

        $("#tfid1").sendKeys("D:\\For_test\\uk_windows_8_1_pro_vl_x86_dvd_2791981.iso"); //аплоадим файл больше 2Гб
        $("#uploadUIContainer2").should(appear); //аплоад попап с ошибкой
        $(".ii .cc .queueWrapper .filelist .uiFileError .uploadErrorByPremium .submit-blue").should(appear);
        $(".ii .cc .queueWrapper .filelist .uiFileError .uploadErrorByPremium .submit-blue").click(); //нажимаем на Купить премиум
        $("#accountPopupTitle").should(Condition.appear); // премиум попап
        $("#upgradeLink").should(Condition.appear); // премиум попап
        $("#premiumColumnSelect").should(Condition.appear); // премиум попап
    }
}
