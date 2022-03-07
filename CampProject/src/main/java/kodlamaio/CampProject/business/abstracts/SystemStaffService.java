package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.SystemStaff;
import kodlamaio.CampProject.entities.concretes.dtos.SystemStaffDto;

import java.util.List;

public interface SystemStaffService extends BaseService<SystemStaffDto> {

    Result register(SystemStaffDto systemStaffDto);
    DataResult<List<SystemStaff>> getAll();
    DataResult<SystemStaff> getById(int id);
}
