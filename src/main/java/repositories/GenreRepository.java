package repositories;

import models.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepository {

    private List<Genre> genres;

    public List<Genre> findAll() {
        return genres;
    }

    public void save(Genre genre) {
        genres.add(genre);
    }

    public Genre findOne(Genre genre){
        return genres.stream().filter(a->a.equals(genre)).findAny().orElse(null);
    }

    public Genre findById(int id){
        return genres.stream().filter(a->a.getId()==id).findAny().orElse(null);
    }

    public void delete(Genre genre){
        genres.remove(genre);
    }
}
