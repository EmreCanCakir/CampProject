package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobSeekerLanguage;
import kodlamaio.CampProject.entities.concretes.JobSeekerSchool;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerLanguageAddDto;

import java.util.List;

public interface JobSeekerLanguageService extends BaseService<JobSeekerLanguageAddDto> {

    DataResult<List<JobSeekerLanguage>> getAll();

    DataResult<JobSeekerLanguage> getByJobSeekerId(int jobSeekerId);

    DataResult<JobSeekerLanguage> getByLanguageId(int languageId);

    Result addMultiple(List<JobSeekerLanguageAddDto> jobSeekerLanguageAddDto);

}
