package repositories;

import errors.ModelNotFoundException;
import models.FilmCompany;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmCompanyRepository {

    private final List<FilmCompany> FilmCompanies = new ArrayList<>();

    public List<FilmCompany> findAll() {
        return FilmCompanies;
    }

    public void save(FilmCompany filmCompany) {
        FilmCompanies.add(filmCompany);
    }

    public FilmCompany findOne(FilmCompany filmCompany){
        return FilmCompanies.stream().filter(a->a.equals(filmCompany)).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public FilmCompany findById(int id){
        return FilmCompanies.stream().filter(a->a.getId()==id).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public void delete(FilmCompany filmCompany){
        FilmCompanies.remove(filmCompany);
    }
}
