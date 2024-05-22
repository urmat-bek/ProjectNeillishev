package org.example.dao;


import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {


    private static int COUNT_PEOPLE;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++COUNT_PEOPLE, "Aziret"));
        people.add(new Person(++COUNT_PEOPLE, "Aknazar"));
        people.add(new Person(++COUNT_PEOPLE, "Tima"));
        people.add(new Person(++COUNT_PEOPLE, "Nuraly"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

}
