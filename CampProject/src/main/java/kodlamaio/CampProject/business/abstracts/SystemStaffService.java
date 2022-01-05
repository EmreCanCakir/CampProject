package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.SystemStaff;

public interface SystemStaffService extends BaseService<SystemStaff> {

    Result register(SystemStaff systemStaff);

}
