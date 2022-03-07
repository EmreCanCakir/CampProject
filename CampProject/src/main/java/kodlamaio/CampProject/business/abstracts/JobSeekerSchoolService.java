package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobSeekerSchool;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerSchoolAddDto;

import java.util.List;

public interface JobSeekerSchoolService extends BaseService<JobSeekerSchoolAddDto> {

    DataResult<List<JobSeekerSchool>> getAll();

    DataResult<JobSeekerSchool> getByJobSeekerId(int jobSeekerId);

    DataResult<JobSeekerSchool> getBySchoolId(int schoolId);

    Result addMultiple(List<JobSeekerSchoolAddDto> jobSeekerSchoolAddDto);

}
