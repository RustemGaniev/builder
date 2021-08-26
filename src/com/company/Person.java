package com.company;

import java.util.Optional;
import java.util.OptionalInt;

public class Person {

    protected final String  name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(PersonBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.address = builder.address;
        this.age = builder.age;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        Optional<String> city = Optional.ofNullable(getAddress());
        return city.isPresent();


    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (OptionalInt.of(age).isPresent()) {
            return OptionalInt.of(age);
        } else {
            System.out.println(" Возраст не определен ! ");
            return null;
        }
    }

    public void setAge(int childAge) {
        if (childAge < 0 | childAge > 128) {
            throw new IllegalArgumentException(" \n Некорректное значение возраста ! \n");
        } else {
            this.age = childAge;
        }
    }

    public String getAddress() {
        Optional<String> city = Optional.ofNullable(address);
        return city.orElse(" Город прживания не известен ! ");
    }

    public String setAddress(String city) {
        this.address = city;
        return address;
    }

    public void happyBirthDay() {
        if (getAge().isPresent()) {
            int newAge = getAge().getAsInt() + 1;
            System.out.println(" \n Happy Birthday Dear " + getName() + " !!! \n ");
            setAge(newAge);
        } else {
            System.out.println("  \n Возраст не извeстен ! \n ");
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.surname = this.surname;
        child.address = this.address;
        return child;
    }

    @Override
    public String toString() {

        return " \n Имя : " + name + " \n Фамилия : " + surname + " \n Город проживания : " + address
                + " \n Возраст : " + age;
    }

}
