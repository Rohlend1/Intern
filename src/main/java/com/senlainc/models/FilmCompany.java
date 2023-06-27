package com.senlainc.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "film_company")
@Data
@NoArgsConstructor
public class FilmCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "filmCompany",cascade = CascadeType.ALL)
    private List<Movie> movies;

    @Column(name = "date_of_foundation")
    private LocalDate dateOfFoundation;

    public FilmCompany(String name, List<Movie> movies, LocalDate dateOfFoundation) {
        this.name = name;
        this.movies = movies;
        this.dateOfFoundation = dateOfFoundation;
    }
}
