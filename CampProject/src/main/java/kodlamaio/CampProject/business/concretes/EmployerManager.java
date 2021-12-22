package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.EmployerService;
import kodlamaio.CampProject.core.business.abstracts.UserCheckService;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.CampProject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private UserCheckService userCheckService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserCheckService userCheckService) {
        this.employerDao = employerDao;
        this.userCheckService = userCheckService;
    }

    @Override
    public Result add(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult("Employer is added");
    }


    @Override
    public Result delete(Employer employer) {
        this.employerDao.delete(employer);
        return new SuccessResult("Employer is deleted. ");
    }

    @Override
    public Result update(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult("Employer is updated. ");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(), "Is verenler listelendi. ");
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

    private Result isCorporateEmailValid(String email, String website) {
        return email.split("@")[1].equals(website) ? new SuccessResult() : new ErrorResult("Email is not valid. ");
    }

    private Result arePasswordsMatches(String password, String passwordRepeat) {
        if (password.equals(passwordRepeat)) {
            return new SuccessResult();
        } else {
            return new ErrorResult("Password and Confirm Password are not matches");
        }
    }

    @Override
    public Result register(Employer employer) {
        final Result businessRuleResult = BusinessRules.run(
                isCorporateEmailValid(employer.getEmail(), employer.getWebsite()),
                isNotCorporateEmailExist(employer.getEmail()),
                arePasswordsMatches(employer.getPassword(), employer.getPasswordRepeat()),
                userCheckService.isValidPassword(employer.getPassword()),
                userCheckService.isValidWebsite(employer.getWebsite()),
                userCheckService.isValidPhones(employer.getPhoneNumber())
        );
        if (!businessRuleResult.isSuccess()) {
            return businessRuleResult;
        } else {
            add(employer);
            return new SuccessResult("Employer is Registered successfully. ");
        }
    }

}
