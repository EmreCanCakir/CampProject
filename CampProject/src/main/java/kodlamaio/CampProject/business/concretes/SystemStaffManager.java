package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.SystemStaffService;
import kodlamaio.CampProject.core.business.abstracts.UserCheckService;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.SystemStaffDao;
import kodlamaio.CampProject.entities.concretes.SystemStaff;
import kodlamaio.CampProject.entities.concretes.dtos.SystemStaffDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemStaffManager implements SystemStaffService {
    private SystemStaffDao systemStaffDao;
    private UserCheckService userCheckService;
    private final ModelMapper modelMapper;

    @Autowired
    public SystemStaffManager(SystemStaffDao systemStaffDao, UserCheckService userCheckService,ModelMapper modelMapper) {
        this.systemStaffDao = systemStaffDao;
        this.userCheckService = userCheckService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(SystemStaffDto systemStaffDto) {
        SystemStaff systemStaff = modelMapper.map(systemStaffDto,SystemStaff.class);
        if (this.systemStaffDao.findByEmail(systemStaffDto.getEmail()).isEmpty()) {
            this.systemStaffDao.save(systemStaff);
            return new SuccessResult("System Staff is added");
        }
        return new ErrorResult("System Staff is not added because email is already exist. ");
    }

    @Override
    public Result delete(SystemStaffDto systemStaffDto) {
        SystemStaff systemStaff = modelMapper.map(systemStaffDto,SystemStaff.class);
        this.systemStaffDao.delete(systemStaff);
        return new SuccessResult("System staff is deleted successfully. ");
    }

    @Override
    public Result update(SystemStaffDto systemStaffDto) {
        SystemStaff systemStaff = modelMapper.map(systemStaffDto,SystemStaff.class);
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
    public Result register(SystemStaffDto systemStaffDto) {
        final Result businessRulesResult = BusinessRules.run(
                userCheckService.isValidEmail(systemStaffDto.getEmail()),
                userCheckService.arePasswordsMatches(systemStaffDto.getPassword(), systemStaffDto.getPasswordRepeat())
        );
        if (!businessRulesResult.isSuccess()) {
            return new ErrorResult("System Staff is not registered . ");
        } else {
            add(systemStaffDto);
            return new SuccessResult();
        }
    }
}
