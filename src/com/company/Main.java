package com.company;

public class Main {

    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Александра")
                .setSurname("Воландемор")
                .setAddress("Милан")
                .setAge(44)
                .build();
        System.out.println(mom);

        Person son = mom.newChildBuilder()
                .setName("Тимурчик")
                .setAge(15)
                .build();

        System.out.println(" \n У мамы " + mom.name + " есть сын, " + son);

    }
}
