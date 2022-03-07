package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobSeeker;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerAddDto;

import java.util.List;

public interface JobSeekerService extends BaseService<JobSeekerAddDto> {
    Result isNotEmailExist(String email);
    Result isNotIdentityNumberExist(String identityNumber);
    Result register(JobSeekerAddDto jobSeekerAddDto);
    DataResult<JobSeeker> getByIdentityNumber(String identityNumber);
    DataResult<List<JobSeeker>> getAll();
    DataResult<JobSeeker> getById(int id);
}
