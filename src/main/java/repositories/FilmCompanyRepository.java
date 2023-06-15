package repositories;

import models.FilmCompany;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmCompanyRepository {

    private List<FilmCompany> FilmCompanies;

    public List<FilmCompany> findAll() {
        return FilmCompanies;
    }

    public void save(FilmCompany filmCompany) {
        FilmCompanies.add(filmCompany);
    }

    public FilmCompany findOne(FilmCompany filmCompany){
        return FilmCompanies.stream().filter(a->a.equals(filmCompany)).findAny().orElse(null);
    }

    public FilmCompany findById(int id){
        return FilmCompanies.stream().filter(a->a.getId()==id).findAny().orElse(null);
    }

    public void delete(FilmCompany filmCompany){
        FilmCompanies.remove(filmCompany);
    }
}
