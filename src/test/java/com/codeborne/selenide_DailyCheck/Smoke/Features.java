package com.codeborne.selenide_DailyCheck.Smoke;


import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Features {

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
}
