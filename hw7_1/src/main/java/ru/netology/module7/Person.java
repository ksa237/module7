package ru.netology.module7;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;


    protected Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    protected Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public boolean hasAge() {
        return age > 0;
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public PersonBuilder newChildBuilder() {

        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address)
                .setAge(1);
    }


}
