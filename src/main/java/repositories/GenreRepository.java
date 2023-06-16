package repositories;

import errors.ModelNotFoundException;
import models.Genre;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GenreRepository {

    private final List<Genre> genres = new ArrayList<>();

    public List<Genre> findAll() {
        return genres;
    }

    public void save(Genre genre) {
        genres.add(genre);
    }

    public Genre findOne(Genre genre){
        return genres.stream().filter(a->a.equals(genre)).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public Genre findById(int id){
        return genres.stream().filter(a->a.getId()==id).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public void delete(Genre genre){
        genres.remove(genre);
    }
}
