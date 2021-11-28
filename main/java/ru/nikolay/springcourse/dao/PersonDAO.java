package ru.nikolay.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.nikolay.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "James"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Sony"));
        people.add(new Person(++PEOPLE_COUNT, "Nikolay"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
    /*    for (Person person : people) {
            if (person.getId() == id) {
                return person;
            } else {
                return null;
            }
        }
        return null;
             */
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}


