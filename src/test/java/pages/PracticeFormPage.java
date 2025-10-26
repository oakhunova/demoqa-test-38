package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;
import pages.components.NegativeTestCheckResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class PracticeFormPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userPhoneInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement subjectsMenu = $(".subjects-auto-complete__menu");
    private final SelenideElement hobbyCheckbox = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement cityDropdown = $("#city");
    private final SelenideElement submitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();
    NegativeTestCheckResultComponent negativeTestCheckResultComponent = new NegativeTestCheckResultComponent();


    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;

    }

    public PracticeFormPage setUserPhone(String value) {
        userPhoneInput.setValue(value);
        return this;

    }

    public PracticeFormPage setBirthday(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        subjectsInput.click();
        subjectsInput.setValue(subject);
        subjectsMenu.click();
        return this;
    }

    public PracticeFormPage hobbyCheckbox(String value) {
        hobbyCheckbox.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public PracticeFormPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public PracticeFormPage stateDropdown() {
        stateDropdown.scrollTo().click();
        return this;
    }

    public PracticeFormPage stateCityWrapper(String value) {
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage cityDropdown() {
        cityDropdown.click();
        return this;
    }

    public PracticeFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage verifyResult(String key, String value) {
        checkResultComponent.checkResult(key, value);
        return this;
    }

    public PracticeFormPage verifyResultForNegativeTest() {
        negativeTestCheckResultComponent.negativeTestCheckResult();
        return this;
    }

    public static class FakeData {
        private static final Faker faker = new Faker();
        public static final String firstName = faker.name().firstName();
        public static final String lastName = faker.name().lastName();
        public static final String fullName = firstName + " " + lastName;
        public static final String userEmail = faker.internet().emailAddress();
        public static final String gender = faker.options().option("Male", "Female", "Other");
        public static final String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        public static final String phoneNumberNegative = faker.phoneNumber().subscriberNumber(3);
        public static final String birthDay = String.format("%02d", faker.number().numberBetween(1, 28));
        public static final String birthMonth = faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        public static final String birthYear = String.valueOf(faker.number().numberBetween(1900, 2100));
        public static final String fullBirthDate = birthDay + " " + birthMonth + "," + birthYear;
        public static final String[] subjects = {"Math", "Arts", "Social Studies", "Economics", "Hindi"};
        public static final String subject = faker.options().option(subjects);
        private static final String[] hobbies = {"Sports", "Reading", "Music"};
        public static final String randomHobby = faker.options().option(hobbies);
        private static final String[] pictureFiles = {
                "Cat.jpg", "Cat with hat.jpg", "Beach.jpg", "Skateboarder.jpg"};
        public static final String randomPicture = faker.options().option(pictureFiles);
        private static final String[] getStates = {
                "NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        public static final String randomState = faker.options().option(getStates);

        public static String getRandomCityForState(String state) {
        switch (state) {
            case "NCR" -> {
                return FakeData.faker.options().option("Delhi", "Gurgaon", "Noida");
            }
            case "Uttar Pradesh" -> {
                return FakeData.faker.options().option("Agra", "Lucknow", "Merrut");
            }
            case "Haryana" -> {
                return FakeData.faker.options().option("Karnal", "Panipat");
            }
            case "Rajasthan" -> {
                return FakeData.faker.options().option("Jaipur", "Jaiselmer");
            }
            default -> {
                return ("Delhi");
            }
        }
    }
        public static final String streetAddress = faker.address().streetAddress();
    }
}
