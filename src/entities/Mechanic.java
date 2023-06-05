package entities;

import java.util.Date;
import java.util.Objects;

public class Mechanic {
    private static int counter = 0;
    private int id;
    private int age;
    private String name;
    private Date birthDate;

    public Mechanic(int age, String name, Date birthDate) {
        this.id = ++counter;
        this.age = age;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mechanic mechanic = (Mechanic) o;

        if (id != mechanic.id) return false;
        if (age != mechanic.age) return false;
        if (!Objects.equals(name, mechanic.name)) return false;
        return Objects.equals(birthDate, mechanic.birthDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "entities.Mechanic{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
