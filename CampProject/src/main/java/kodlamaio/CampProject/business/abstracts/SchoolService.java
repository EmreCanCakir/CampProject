package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.School;

import java.util.List;

public interface SchoolService {

    DataResult<List<School>> getAll();
    DataResult<School> getById(int id);
    DataResult<List<School>> getByNameStartsWith(String schoolName);
    Result addSchoolName(String schoolName);

}
