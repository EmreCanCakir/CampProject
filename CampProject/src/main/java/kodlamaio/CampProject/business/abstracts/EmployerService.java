package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.Employer;
import kodlamaio.CampProject.entities.concretes.dtos.EmployerAddDto;

import java.util.List;

public interface EmployerService extends BaseService<EmployerAddDto> {
    Result isNotCorporateEmailExist(String corporateEmail);
    Result register(EmployerAddDto employerAddDto);
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
}
