package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.Employer;

public interface EmployerService extends BaseService<Employer> {
    Result isNotCorporateEmailExist(String corporateEmail);
    Result register(Employer employer);
}
