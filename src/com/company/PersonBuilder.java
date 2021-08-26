package com.company;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String address;


    public PersonBuilder setName(String name) {
        if (name.length() > 35)
            throw new IllegalArgumentException(" \n Слишком длинное имя ! \n");
        else this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname.length() > 55)
            throw new IllegalArgumentException((" \n Слишком длинная фамилия !  \n"));
        else this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 | age > 140)
            throw new IllegalArgumentException(" \n Некорректное значение возраста ! \n");
        else this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address.length() > 200)
            throw new IllegalArgumentException(" \n Слишком длинное название города ! \n ");
        else this.address = address;
        return this;
    }

    public Person build() {
        return new Person(this);
    }

    @Override
    public String toString() {
        return " \n Имя : " + name + " \n Фамилия : " + surname + " \n Город проживания : " + address
                + " \n Возраст : " + age;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode() * age;
        result = 29 * result + address.hashCode() * age;
        return result;
    }
}
