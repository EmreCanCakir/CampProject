package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobSeekerExperience;
import kodlamaio.CampProject.entities.concretes.dtos.JobExperienceAddDto;

import java.util.List;

public interface JobSeekerExperienceService extends BaseService<JobExperienceAddDto> {


    DataResult<JobSeekerExperience> getById(int id);

    DataResult<List<JobSeekerExperience>> getAll();

    DataResult<List<JobSeekerExperience>> getByPositionStartsWith(String jobExperience);

}
