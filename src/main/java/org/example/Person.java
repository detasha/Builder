package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    protected String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        if (age > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAddress() {
        if (address == null || address.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
        return this.address;
    }

    public int happyBirthday() {
        return age++;
    }

    @Override
    public String toString() {
        StringBuilder x = new StringBuilder();
        x.append(getName())
                .append(" ")
                .append(getSurname());
        if (hasAddress())
            x.append(" из ")
                    .append(getAddress());
        if (hasAge())
            x.append(" ")
                    .append(getAge().getAsInt())
                    .append(" лет");

        return x.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && address.equals(person.address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(address);
    }

}
