package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.components.PracticeFormPage;
import static io.qameta.allure.Allure.step;

public class PracticeFormJenkinsTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        step("Open form", () -> {
            practiceFormPage.openPage()
                    .removeBanner();
        });
        step("Fill form", () -> {
            practiceFormPage.setFirstName("Alex")
                    .setLastName("Ivanov")
                    .setUserEmail("test7@mail.com")
                    .setGender("Male")
                    .setUserPhone("1234567890")
                    .setBirthday("01", "January", "1990")
                    .setSubject("Arts")
                    .hobbyCheckbox("Music")
                    .uploadPicture("Cat.jpg")
                    .setAddress("Worldwide")
                    .stateDropdown()
                    .stateCityWrapper("NCR")
                    .cityDropdown()
                    .stateCityWrapper("Delhi")
                    .submitForm();
        });
        step("Verify results", () -> {
            practiceFormPage.verifyResult("Student Name", "Alex Ivanov")
                    .verifyResult("Student Email", "test7@mail.com")
                    .verifyResult("Gender", "Male")
                    .verifyResult("Mobile", "1234567890")
                    .verifyResult("Date of Birth", "01 January,1990")
                    .verifyResult("Subjects", "Arts")
                    .verifyResult("Hobbies", "Music")
                    .verifyResult("Picture", "Cat.jpg")
                    .verifyResult("Address", "Worldwide")
                    .verifyResult("State and City", "NCR Delhi");
        });
    }

        @Test
        @Tag("demoqa")
        void fillRequiredFieldsTest () {
            step("Open form", () -> {
            practiceFormPage.openPage()
                    .removeBanner();
            });
            step("Fill form", () -> {
                practiceFormPage.setFirstName("Alex")
                        .setLastName("Ivanov")
                        .setGender("Male")
                        .setUserPhone("1234567890")
                        .submitForm();
            });
            step("Verify results", () -> {
                practiceFormPage.verifyResult("Student Name", "Alex Ivanov")
                        .verifyResult("Gender", "Male")
                        .verifyResult("Mobile", "1234567890");
            });
            }

        @Test
        @Tag("demoqa")
        void invalidMobileNumberTest () {
            step("Open form", () -> {
                practiceFormPage.openPage()
                        .removeBanner();
            });
            step("Fill form", () -> {
                practiceFormPage.setFirstName("Alex")
                        .setLastName("Ivanov")
                        .setGender("Male")
                        .setUserPhone("123")
                        .submitForm();
            });
            step("Verify results", () -> {
                practiceFormPage.verifyResultForNegativeTest();
            });
            }
        }
