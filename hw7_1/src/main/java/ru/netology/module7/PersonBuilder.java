package ru.netology.module7;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    PersonBuilder() {

    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {

        if (age <= 0) {
            throw new IllegalArgumentException("Возраст должен быть больше 0");
        }

        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {

        String listErrFields = "";

        // проверка обязательных полей name, surname
        if (name == null || name.isEmpty()) {
            listErrFields += "name\t";
        }

        if (surname == null || surname.isEmpty()) {
            ;
            listErrFields += "surname";
        }

        if (!listErrFields.isEmpty()) {
            throw new IllegalArgumentException("Не все обязательные поля заполнены, список незаполненных полей: " + listErrFields);
        }


        Person returnPerson = null;

        if (age > 0) {
            returnPerson = new Person(name, surname, age);
        } else {
            returnPerson = new Person(name, surname);
        }

        if (!(address == null || address.isEmpty())) {
            returnPerson.setAddress(address);
        }

        return returnPerson;

    }


}





