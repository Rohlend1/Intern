package com.senlainc.dto.actors;

import com.senlainc.models.Movie;
import com.senlainc.util.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class ActorDTO {

    private String firstName;

    private String lastName;

    private Gender gender;

    private String country;

    private LocalDate birthDate;

    private Integer age;

    private List<Movie> movies;
}
