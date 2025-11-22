package tests;

import org.junit.jupiter.api.Test;
import pages.FakeData;
import pages.components.PracticeFormPage;

public class PracticeFormWithFakerTests extends TestBase{

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    FakeData fakeData = new FakeData();
    String state = fakeData.randomState;
    String city = fakeData.getRandomCityForState(state);
    String fullCityState = state + " " + city;

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName(fakeData.firstName)
                .setLastName(fakeData.lastName)
                .setUserEmail(fakeData.userEmail)
                .setGender(fakeData.gender)
                .setUserPhone(fakeData.phoneNumber)
                .setBirthday(fakeData.birthDay, fakeData.birthMonth, fakeData.birthYear)
                .setSubject(fakeData.subject)
                .hobbyCheckbox(fakeData.randomHobby)
                .uploadPicture(fakeData.randomPicture)
                .setAddress(fakeData.streetAddress)
                .stateDropdown()
                .stateCityWrapper(state)
                .cityDropdown()
                .stateCityWrapper(city)
                .submitForm()
                .verifyResult("Student Name", fakeData.fullName)
                .verifyResult("Student Email", fakeData.userEmail)
                .verifyResult("Gender", fakeData.gender)
                .verifyResult("Mobile", fakeData.phoneNumber)
                .verifyResult("Date of Birth", fakeData.fullBirthDate)
                .verifyResult("Subjects", fakeData.subject)
                .verifyResult("Hobbies", fakeData.randomHobby)
                .verifyResult("Picture", fakeData.randomPicture)
                .verifyResult("Address", fakeData.streetAddress)
                .verifyResult("State and City", fullCityState);

    }
    @Test
    void fillRequiredFieldsTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName(fakeData.firstName)
                .setLastName(fakeData.lastName)
                .setGender(fakeData.gender)
                .setUserPhone(fakeData.phoneNumber)
                .submitForm()
                .verifyResult("Student Name", fakeData.fullName)
                .verifyResult("Gender", fakeData.gender)
                .verifyResult("Mobile", fakeData.phoneNumber);
    }
    @Test
    void invalidMobileNumberTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName(fakeData.firstName)
                .setLastName(fakeData.lastName)
                .setGender(fakeData.gender)
                .setUserPhone(fakeData.phoneNumberNegative)
                .submitForm()
                .verifyResultForNegativeTest();
    }
}