package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.EmployerService;
import kodlamaio.CampProject.core.business.abstracts.UserCheckService;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.CampProject.entities.concretes.Employer;
import kodlamaio.CampProject.entities.concretes.dtos.EmployerAddDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private UserCheckService userCheckService;
    private ModelMapper modelMapper;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserCheckService userCheckService,ModelMapper modelMapper) {
        this.employerDao = employerDao;
        this.userCheckService = userCheckService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(EmployerAddDto employerAddDto) {
        if(!this.employerDao.findByEmail(employerAddDto.getEmail()).isEmpty()){
            return new ErrorResult("Email is already exist");
        }
        Employer employer = modelMapper.map(employerAddDto,Employer.class);
        this.employerDao.save(employer);
        return new SuccessResult("Employer is registered successfully");
    }


    @Override
    public Result delete(EmployerAddDto employerAddDto) {
        Employer employer = modelMapper.map(employerAddDto,Employer.class);
        this.employerDao.delete(employer);
        return new SuccessResult("Employer is deleted. ");
    }

    @Override
    public Result update(EmployerAddDto employerAddDto) {
        Employer employer = modelMapper.map(employerAddDto,Employer.class);
        this.employerDao.save(employer);
        return new SuccessResult("Employer is updated. ");
    }
    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(), "Employers are listed. ");
    }

    @Override
    public DataResult getById(int id) {
        final Optional<Employer> employer = this.employerDao.findById(id);
        if (employer.isEmpty()) {
            return new ErrorDataResult();
        } else {
            return new SuccessDataResult(employer.get());
        }
    }

    @Override
    public Result isNotCorporateEmailExist(String email) {
        if (this.employerDao.findByEmail(email).isEmpty())
            return new SuccessResult();
        return new ErrorResult("Email already exist . ");
    }

    private Result arePasswordsMatches(String password, String passwordRepeat) {
        if (password.equals(passwordRepeat)) {
            return new SuccessResult();
        } else {
            return new ErrorResult("Password and Confirm Password are not matches");
        }
    }

    @Override
    public Result register(EmployerAddDto employerAddDto) {
        final Result businessRuleResult = BusinessRules.run(
                isNotCorporateEmailExist(employerAddDto.getEmail()),
                arePasswordsMatches(employerAddDto.getPassword(), employerAddDto.getPasswordRepeat()),
                userCheckService.isValidPassword(employerAddDto.getPassword()),
                userCheckService.isValidWebsiteDiffDomain(employerAddDto.getEmail(),employerAddDto.getWebsite()),
                userCheckService.isValidWebsite(employerAddDto.getWebsite()),
                userCheckService.isValidPhones(employerAddDto.getPhoneNumber())
        );
        if (!businessRuleResult.isSuccess()) {
            return businessRuleResult;
        } else {
            add(employerAddDto);
            return new SuccessResult();
        }
    }

}
