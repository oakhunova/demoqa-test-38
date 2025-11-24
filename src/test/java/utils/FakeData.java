package utils;

import com.github.javafaker.Faker;

public class FakeData {
    Faker faker = new Faker();
    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            fullName = firstName + " " + lastName,
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            phoneNumberNegative = faker.phoneNumber().subscriberNumber(3),
            birthDay = String.format("%02d", faker.number().numberBetween(1, 28)),
            birthMonth = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"),
            birthYear = String.valueOf(faker.number().numberBetween(1900, 2100)),
            fullBirthDate = birthDay + " " + birthMonth + "," + birthYear,
            subject = faker.options().option("Math", "Arts", "Social Studies", "Economics", "Hindi"),
            randomHobby = faker.options().option("Sports", "Reading", "Music"),
            randomPicture = faker.options().option( "Cat.jpg", "Cat with hat.jpg", "Beach.jpg", "Skateboarder.jpg"),
            streetAddress = faker.address().streetAddress(),
            randomState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public String getRandomCityForState(String state) {
        switch (state) {
            case "NCR" -> {
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            }
            case "Uttar Pradesh" -> {
                return faker.options().option("Agra", "Lucknow", "Merrut");
            }
            case "Haryana" -> {
                return faker.options().option("Karnal", "Panipat");
            }
            case "Rajasthan" -> {
                return faker.options().option("Jaipur", "Jaiselmer");
            }
            default -> {
                return ("Delhi");
            }
        }
    }
}
