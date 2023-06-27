package com.senlainc.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Genre")
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "genre_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;

    public Genre(String name, List<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }
}
