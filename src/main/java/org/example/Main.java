package org.example;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        System.out.println("Есть ли у мамы возраст - " + mom.hasAge());
        System.out.println("Есть ли у мамы адрес - " + mom.hasAddress());
        mom.setAddress("Москва");
        System.out.println("Новый адрес мамы = " + mom.address);

        System.out.println(mom.getAddress());
        System.out.println(mom.getName());
        System.out.println(mom.getSurname());
        System.out.println(mom.getAge().getAsInt());


        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);
        System.out.println("Есть ли у сына возраст - " + son.hasAge());

        mom.happyBirthday();
        System.out.println("Маме исполнилось: " + mom.age +" года");

        Person pap = new PersonBuilder()
                .setName("Рудольф")
                .setSurname("Вольф")
                .setAge(31)
                .build();
        System.out.println("Есть ли у папы адрес - " + pap.hasAddress());
        pap.setAddress("Санкт-Петербург");
        System.out.println("Новый адрес папы = " + pap.address);

        Person ded = new PersonBuilder()
                .setName("Иван")
                .setSurname("Вольф")
                .setAge(90)
                .setAddress("деревня Васькино")
                .build();
        System.out.println(ded);
        System.out.println("Есть ли у деда возраст - " + ded.hasAge());
        ded.setAddress("Вологда");
        System.out.println("Новый адрес деда = " + ded.address);

       //mom.setAge(50);


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