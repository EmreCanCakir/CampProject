package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobSeeker;

public interface JobSeekerService extends BaseService<JobSeeker> {
    Result isNotEmailExist(String email);
    Result isNotIdentityNumberExist(String identityNumber);
    Result register(JobSeeker jobSeeker);
    DataResult<JobSeeker> getByIdentityNumber(String identityNumber);
}
