package org.example;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        System.out.println(mom.hasAge());
        System.out.println(mom.hasAddress());

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);
        System.out.println(son.hasAge());

        Person pap = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .build();
        System.out.println(pap.hasAddress());
        mom.address = "Moscow";
        System.out.println("New address = " + mom.address);
        mom.happyBirthday();
        System.out.println(mom.happyBirthday());


        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}