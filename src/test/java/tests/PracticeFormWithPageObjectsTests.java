package tests;

import org.junit.jupiter.api.Test;
import pages.components.PracticeFormPage;

public class PracticeFormWithPageObjectsTests extends TestBase{

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName("Alex")
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
                .submitForm()
                .verifyResult("Student Name", "Alex Ivanov")
                .verifyResult("Student Email", "test7@mail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "01 January,1990")
                .verifyResult("Subjects", "Arts")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "Cat.jpg")
                .verifyResult("Address", "Worldwide")
                .verifyResult("State and City", "NCR Delhi");

    }
    @Test
    void fillRequiredFieldsTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setGender("Male")
                .setUserPhone("1234567890")
                .submitForm()
                .verifyResult("Student Name", "Alex Ivanov")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567890");
    }
    @Test
    void invalidMobileNumberTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setGender("Male")
                .setUserPhone("123")
                .submitForm()
                .verifyResultForNegativeTest();
    }
}

