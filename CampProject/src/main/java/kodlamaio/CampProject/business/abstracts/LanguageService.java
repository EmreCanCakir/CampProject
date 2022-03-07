package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();
    DataResult<Language> getById(int id);
    DataResult<List<Language>> getByNameStartsWith(String languageName);
    Result addLanguage(String language);

}
