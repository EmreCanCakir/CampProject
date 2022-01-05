package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.SystemStaffService;
import kodlamaio.CampProject.core.business.abstracts.UserCheckService;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.SystemStaffDao;
import kodlamaio.CampProject.entities.concretes.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemStaffManager implements SystemStaffService {
    private SystemStaffDao systemStaffDao;
    private UserCheckService userCheckService;

    @Autowired
    public SystemStaffManager(SystemStaffDao systemStaffDao, UserCheckService userCheckService) {
        this.systemStaffDao = systemStaffDao;
        this.userCheckService = userCheckService;
    }

    @Override
    public Result add(SystemStaff systemStaff) {
        if (this.systemStaffDao.findByEmail(systemStaff.getEmail()).isEmpty()) {
            this.systemStaffDao.save(systemStaff);
            return new SuccessResult("System Staff is added");
        }
        return new ErrorResult("System Staff is not added because email is already exist. ");
    }

    @Override
    public Result delete(SystemStaff systemStaff) {
        this.systemStaffDao.delete(systemStaff);
        return new SuccessResult("System staff is deleted successfully. ");
    }

    @Override
    public Result update(SystemStaff systemStaff) {
        this.systemStaffDao.save(systemStaff);
        return new SuccessResult("System staff is updated. ");
    }

    @Override
    public DataResult<List<SystemStaff>> getAll() {
        return new SuccessDataResult<>(this.systemStaffDao.findAll(), "System staffs are listed. ");
    }

    @Override
    public DataResult<SystemStaff> getById(int id) {
        return new SuccessDataResult<>(this.systemStaffDao.getById(id));
    }

    @Override
    public Result register(SystemStaff systemStaff) {
        final Result businessRulesResult = BusinessRules.run(
                userCheckService.isValidEmail(systemStaff.getEmail()),
                userCheckService.arePasswordsMatches(systemStaff.getPassword(), systemStaff.getPasswordRepeat())
        );
        if (!businessRulesResult.isSuccess()) {
            return new ErrorResult("System Staff is not registered . ");
        } else {
            add(systemStaff);
            return new SuccessResult();
        }
    }
}
