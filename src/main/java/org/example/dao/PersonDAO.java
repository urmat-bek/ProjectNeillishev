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
        people.add(new Person(++COUNT_PEOPLE, "Aziret", 21, "aziret@gmail.com"));
        people.add(new Person(++COUNT_PEOPLE, "Aknazar", 20, "aknazar@gmail.com"));
        people.add(new Person(++COUNT_PEOPLE, "Tima", 22, "tima@gmail.com"));
        people.add(new Person(++COUNT_PEOPLE, "Nuraly", 21, "nur@gamil.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++COUNT_PEOPLE);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

//    public void save(Person person){
//        person.setId(++COUNT_PEOPLE);
//        people.add(person);
//    }
//
//    public void update(int id, Person updatedPerson){
//        Person personToBeUpdated = show(id);
//
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
//    }
//
//    public void delete(int id){
//        people.removeIf(p -> p.getId() == id);
//    }

}
