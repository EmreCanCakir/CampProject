package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.LanguageService;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.LanguageDao;
import kodlamaio.CampProject.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class LanguageManager implements LanguageService {

    @Autowired
    private LanguageDao languageDao;

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<>(this.languageDao.findAll());
    }

    @Override
    public DataResult<Language> getById(int id) {
        return new SuccessDataResult<>(this.languageDao.getById(id));
    }

    @Override
    public DataResult<List<Language>> getByNameStartsWith(String languageName) {
        return new SuccessDataResult<>(this.languageDao.getByNameStartsWith(languageName.toUpperCase(Locale.ROOT)));
    }

    @Override
    public Result addLanguage(String language) {
        if(this.languageDao.getByName(language).isEmpty()){
            this.languageDao.save(new Language(language.toUpperCase(Locale.ROOT)));
            return new SuccessResult("Language is added. ");
        }
        return new ErrorResult("Language is already exist. ");
    }
}
