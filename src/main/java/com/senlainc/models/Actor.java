package com.senlainc.models;

import com.senlainc.util.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Actor {

    private int id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private String country;

    private LocalDate birthDate;

    private int age;

    private List<Movie> movies;

    public Actor() {
    }

    public Actor(String firstName, String lastName, Gender gender, String country, LocalDate birthDate, int age, List<Movie> movies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.birthDate = birthDate;
        this.age = age;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id && age == actor.age && Objects.equals(firstName, actor.firstName) && Objects.equals(lastName, actor.lastName) && gender == actor.gender && Objects.equals(country, actor.country) && Objects.equals(birthDate, actor.birthDate) && Objects.equals(movies, actor.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, country, birthDate, age, movies);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                '}';
    }
}
