package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormWithFakerTests extends TestBase{

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    String state = PracticeFormPage.FakeData.randomState;
    String city = PracticeFormPage.FakeData.getRandomCityForState(state);
    String fullCityState = state + " " + city;

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName(PracticeFormPage.FakeData.firstName)
                .setLastName(PracticeFormPage.FakeData.lastName)
                .setUserEmail(PracticeFormPage.FakeData.userEmail)
                .setGender(PracticeFormPage.FakeData.gender)
                .setUserPhone(PracticeFormPage.FakeData.phoneNumber)
                .setBirthday(PracticeFormPage.FakeData.birthDay, PracticeFormPage.FakeData.birthMonth, PracticeFormPage.FakeData.birthYear)
                .setSubject(PracticeFormPage.FakeData.subject)
                .hobbyCheckbox(PracticeFormPage.FakeData.randomHobby)
                .uploadPicture(PracticeFormPage.FakeData.randomPicture)
                .setAddress(PracticeFormPage.FakeData.streetAddress)
                .stateDropdown()
                .stateCityWrapper(state)
                .cityDropdown()
                .stateCityWrapper(city)
                .submitForm()
                .verifyResult("Student Name", PracticeFormPage.FakeData.fullName)
                .verifyResult("Student Email", PracticeFormPage.FakeData.userEmail)
                .verifyResult("Gender", PracticeFormPage.FakeData.gender)
                .verifyResult("Mobile", PracticeFormPage.FakeData.phoneNumber)
                .verifyResult("Date of Birth", PracticeFormPage.FakeData.fullBirthDate)
                .verifyResult("Subjects", PracticeFormPage.FakeData.subject)
                .verifyResult("Hobbies", PracticeFormPage.FakeData.randomHobby)
                .verifyResult("Picture", PracticeFormPage.FakeData.randomPicture)
                .verifyResult("Address", PracticeFormPage.FakeData.streetAddress)
                .verifyResult("State and City", fullCityState);

    }
    @Test
    void fillRequiredFieldsTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName(PracticeFormPage.FakeData.firstName)
                .setLastName(PracticeFormPage.FakeData.lastName)
                .setGender(PracticeFormPage.FakeData.gender)
                .setUserPhone(PracticeFormPage.FakeData.phoneNumber)
                .submitForm()
                .verifyResult("Student Name", PracticeFormPage.FakeData.fullName)
                .verifyResult("Gender", PracticeFormPage.FakeData.gender)
                .verifyResult("Mobile", PracticeFormPage.FakeData.phoneNumber);
    }
    @Test
    void invalidMobileNumberTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName(PracticeFormPage.FakeData.firstName)
                .setLastName(PracticeFormPage.FakeData.lastName)
                .setGender(PracticeFormPage.FakeData.gender)
                .setUserPhone(PracticeFormPage.FakeData.phoneNumberNegative)
                .submitForm()
                .verifyResultForNegativeTest();
    }
}