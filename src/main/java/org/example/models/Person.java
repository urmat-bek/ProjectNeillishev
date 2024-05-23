package org.example.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "Имя не должен быть пустым!")
    @Size(min = 2, max = 30, message = "Имя должен состовить не менее 2 или не больше 30 символов!")
    private String name;

    @Min(value = 0, message = "Восраст не должен быть отрицательным!")
    private int age;

    @NotEmpty(message = "Почта не должен быть пустым!")
    @Email(message = "Почта должен быть валидным!")
    private String email;

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public Person(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
