package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.ElementsCollection;

public class QAGuruTest {
    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test7@mail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Arts");
        $(".subjects-auto-complete__menu").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("Cat.jpg");
        $("#currentAddress").setValue("Worldwide");
        $("#state").scrollTo().click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        ElementsCollection rows = $(".table-responsive").findAll("tr");
        rows.findBy(text("Student Name"))
                .findAll("td").get(1)
                .shouldHave(text("Alex Ivanov"));
        rows.findBy(text("Student Email"))
                .findAll("td").get(1)
                .shouldHave(text("test7@mail.com"));
        rows.findBy(text("Gender"))
                .findAll("td").get(1)
                .shouldHave(text("Male"));
        rows.findBy(text("Mobile"))
                .findAll("td").get(1)
                .shouldHave(text("1234567890"));
        rows.findBy(text("Date of Birth"))
                .findAll("td").get(1)
                .shouldHave(text("01 January,1990"));
        rows.findBy(text("Subjects"))
                .findAll("td").get(1)
                .shouldHave(text("Arts"));
        rows.findBy(text("Hobbies"))
                .findAll("td").get(1)
                .shouldHave(text("Music"));
        rows.findBy(text("Picture"))
                .findAll("td").get(1)
                .shouldHave(text("Cat.jpg"));
        rows.findBy(text("Address"))
                .findAll("td").get(1)
                .shouldHave(text("Worldwide"));
        rows.findBy(text("State and City"))
                .findAll("td").get(1)
                .shouldHave(text("NCR Delhi"));
    }
}