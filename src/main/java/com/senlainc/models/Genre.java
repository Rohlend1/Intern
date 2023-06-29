package com.senlainc.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Genre")
@Data
@NoArgsConstructor
@NamedQuery(name = "findGenreLike", query = "SELECT g FROM Genre g WHERE g.name LIKE :character")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

    public Genre(String name, List<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }
}
