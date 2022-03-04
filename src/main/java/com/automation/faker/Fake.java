package com.automation.faker;
import com.github.javafaker.Faker;

public class Fake {

    public String createFakeId(int count)
    {
        Faker faker = new Faker();
       return faker.number().digits(count);

    }
}
