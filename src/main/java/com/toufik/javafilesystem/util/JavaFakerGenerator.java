package com.toufik.javafilesystem.util;

import com.github.javafaker.Faker;
import org.junit.Test;

public class JavaFakerGenerator {


    public static String createFakePerson(){
        Faker faker = new Faker();

        String streetName = faker.address().streetName();
        String number = faker.address().buildingNumber();
        String city = faker.address().city();
        String country = faker.address().country();

        return String.format("%s\n%s\n%s\n%s",
                number,
                streetName,
                city,
                country);
    }
}
