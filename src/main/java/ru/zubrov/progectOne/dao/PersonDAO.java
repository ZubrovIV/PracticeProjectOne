package ru.zubrov.progectOne.dao;

import org.springframework.stereotype.Component;
import ru.zubrov.progectOne.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom"));
        people.add(new Person(++PEOPLE_COUNT,"Marat"));
        people.add(new Person(++PEOPLE_COUNT,"Slava"));
        people.add(new Person(++PEOPLE_COUNT,"Elena"));
    }
    public List<Person> index (){
        return people;
    }
    public Person show (int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }

}
