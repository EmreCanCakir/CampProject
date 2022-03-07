package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.SchoolService;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.SchoolDao;
import kodlamaio.CampProject.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class SchoolManager implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<>(this.schoolDao.findAll(),"Schools are listed. ");
    }

    @Override
    public DataResult<School> getById(int id) {
        return new SuccessDataResult<>(this.schoolDao.getById(id));
    }

    @Override
    public DataResult<List<School>> getByNameStartsWith(String schoolName) {
        return new SuccessDataResult<>(this.schoolDao.getBySchoolNameStartsWith(schoolName.toUpperCase(Locale.ROOT)));
    }

    @Override
    public Result addSchoolName(String schoolName) {
        if(this.schoolDao.getBySchoolName(schoolName).isEmpty()){
            this.schoolDao.save(new School(schoolName.toUpperCase(Locale.ROOT)));
            return new SuccessResult();
        }
        return new ErrorResult("School Name is already exist. ");
    }
}
