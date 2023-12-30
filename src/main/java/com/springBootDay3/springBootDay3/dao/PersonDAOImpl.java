package com.springBootDay3.springBootDay3.dao;

import com.springBootDay3.springBootDay3.database.PersonDB;
import com.springBootDay3.springBootDay3.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Override
    public void printListPersons(List<Person> persons) {
        persons.forEach(System.out::println);
    }

    @Override
    public List<Person> getAll() {
        return PersonDB.persons;
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return PersonDB.persons.stream()
                .sorted(Comparator.comparing(Person::getFullName))
                .toList();
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return PersonDB.persons.stream()
                .sorted(Comparator.comparing(Person::getFullName).reversed())
                .toList();
    }

    @Override
    public List<String> getSortedJobs() {
        List<String> listJob = new ArrayList<>();
        PersonDB.persons.stream().forEach(person -> listJob.add(person.getJob()));
        return listJob.stream().sorted().toList();
    }

    @Override
    public List<String> getSortedCities() {
        List<String> listCity = new ArrayList<>();
        PersonDB.persons.stream().forEach(person -> listCity.add(person.getCity()));
        return listCity.stream().sorted().toList();
    }

    @Override
    public List<String> femaleNames() {
        List<String> listFemaleNames = new ArrayList<>();
        PersonDB.persons
                .stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female"))
                .forEach(person -> listFemaleNames.add(person.getFullName()));
        return listFemaleNames;
    }

    @Override
    public Person highestEarner() {
        return PersonDB.persons.stream().max((o1, o2) -> o1.getSalary() - o2.getSalary()).get();
    }

    @Override
    public List<Person> bornAfter1990() {
        List<Person> listPersonBornAfter1990 = new ArrayList<>();
        PersonDB.persons
                .stream()
                .filter(person -> person.getBirthday().getYear() > 1990)
                .forEach(listPersonBornAfter1990::add);
        return listPersonBornAfter1990;
    }

    @Override
    public double averageSalary() {
        return PersonDB.persons.stream().mapToDouble(Person::getSalary).sum() / PersonDB.persons.size();
    }

    @Override
    public double averageAge() {
        return PersonDB.persons.stream().mapToDouble(Person::getAge).sum() / PersonDB.persons.size();
    }

    @Override
    public List<Person> nameContains(String keyword) {
        return PersonDB.persons.stream().filter(person -> person.getFullName().contains(keyword)).toList();
    }

    @Override
    public List<Person> sortedByAgeForMale() {
        return PersonDB.persons.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female"))
                .sorted(Comparator.comparingInt(person -> person.getBirthday().getYear())).toList();
    }

    @Override
    public Person longestName() {
        return PersonDB.persons.stream()
                .max(Comparator.comparingInt(person -> person.getFullName().length())).get();
    }

    @Override
    public List<Person> aboveAverageSalary() {
        return PersonDB.persons.stream()
                .filter(person -> person.getSalary() > averageSalary()).toList();
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return PersonDB.persons.stream().collect(Collectors.groupingBy(Person::getCity));
    }

    @Override
    public Map<String, Integer> groupJobByCount() {
        return PersonDB.persons.stream().collect(Collectors.groupingBy(Person::getJob,Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }

    @Override
    public List<Person> inSalaryRange(int start, int end) {
        return PersonDB.persons.stream()
                .filter(person -> person.getSalary() >= start && person.getSalary() <= end).toList();
    }

    @Override
    public List<Person> startsWith(String prefix) {
        return PersonDB.persons.stream()
                .filter(person -> person.getFullName().startsWith(prefix))
                .toList();
    }

    @Override
    public List<Person> sortByBirthYearDescending() {
        return PersonDB.persons.stream()
                .sorted((o1,o2) -> o2.getBirthday().compareTo(o1.getBirthday()))
                .toList();
    }

    @Override
    public List<Person> top5HighestPaid() {
        return PersonDB.persons.stream()
                .sorted(((o1, o2) -> o2.getSalary() - o1.getSalary()))
                .limit(5).toList();
    }

    @Override
    public List<Person> inAgeRange(int start, int end) {
        return PersonDB.persons.stream()
                .filter(person -> person.getAge() > start && person.getAge() < end)
                .toList();
    }
}
