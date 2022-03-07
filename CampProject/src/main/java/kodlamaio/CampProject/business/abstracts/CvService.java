package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.Cv;
import kodlamaio.CampProject.entities.concretes.dtos.CvAddDto;

public interface CvService {

    DataResult<Cv> getByJobSeekerId(int jobSeekerId);
    DataResult<Cv> getById(int id);
    public Result add(CvAddDto entity);
    public Result deleteById(int id);
}
