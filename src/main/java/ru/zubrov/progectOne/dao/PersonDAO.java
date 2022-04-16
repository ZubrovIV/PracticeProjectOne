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
        people.add(new Person(++PEOPLE_COUNT,"Tom",24,"tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Marat",50,"mar@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Slava",18,"slav@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Elena",53,"elena@mail.ru"));
    }
    public List<Person> index (){
        return people;
    }
    public Person show (int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
    public void save (Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId()==id);
    }
}
