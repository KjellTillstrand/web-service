package com.example.producingwebservice;

import io.spring.guides.gs_producing_web_service.Currency;
import io.spring.guides.gs_producing_web_service.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonRepository {
    private static final Map<String, Person> persons = new HashMap<>();

    @PostConstruct
    public void initData() {

        Person adam = new Person();
        adam.setName("Adam");
        adam.setAdress("Madrid");
        adam.setCurrency(Currency.EUR);
        adam.setAge(23);
        persons.put(adam.getName(), adam);

        Person bertil = new Person();
        bertil.setName("Bertil");
        bertil.setAdress("Stockholm");
        bertil.setCurrency(Currency.SEK);
        bertil.setAge(23);
        persons.put(bertil.getName(), bertil);

    }

    public Person findPerson(String name) {
        Assert.notNull(name, "The persons's name must not be null");
        return persons.get(name);
    }
}
