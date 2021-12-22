package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.JobSeekerService;
import kodlamaio.CampProject.business.abstracts.MernisVerificationService;
import kodlamaio.CampProject.business.adapters.PersonVerificationFromMernis;
import kodlamaio.CampProject.core.business.abstracts.UserCheckService;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.CampProject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private PersonVerificationFromMernis personVerificationFromMernis;
    private MernisVerificationService mernisVerificationService;
    private UserCheckService userCheckService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserCheckService userCheckService) {
        this.jobSeekerDao = jobSeekerDao;
        this.userCheckService = userCheckService;
    }

    @Override
    public Result isNotEmailExist(String email) {
        if (this.jobSeekerDao.findByEmail(email).isEmpty()) {
            return new SuccessResult();
        }
        return new ErrorResult("Email is already exist. ");
    }

    @Override
    public Result isNotIdentityNumberExist(String identityNumber) {
        if (this.jobSeekerDao.findByIdentityNumber(identityNumber).isEmpty()) {
            return new SuccessResult();
        }
        return new ErrorResult("Identity number is already exist. ");
    }

    @Override
    public Result register(JobSeeker jobSeeker) {
        final Result businessRulesResult = BusinessRules.run(
                isMernisVerificationValid(),
                arePasswordMatches(jobSeeker.getPassword(),jobSeeker.getPasswordRepeat()),
                userCheckService.isValidPassword(jobSeeker.getPassword()),
                userCheckService.isValidEmail(jobSeeker.getEmail()),
                userCheckService.isValidIdentityNumber(jobSeeker.getIdentityNumber())
                );
        if(businessRulesResult.isSuccess() ){
            add(jobSeeker);
            return new SuccessResult();
        }
        return new ErrorResult("Job seeker is not registered. ");
    }

    @Override
    public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
        Optional<JobSeeker> jobSeeker = this.jobSeekerDao.findByIdentityNumber(identityNumber);
        if (!jobSeeker.isEmpty())
            return new SuccessDataResult<>(jobSeeker.get());
        return new ErrorDataResult<>("Identity number is not found. ");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        final Result result = BusinessRules.run(isNotIdentityNumberExist(jobSeeker.getIdentityNumber()), isNotEmailExist(jobSeeker.getEmail()));
        if (!result.isSuccess()) {
            return new ErrorResult("Job Seeker is not added ");
        } else {
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult("Job Seeker is added");
        }
    }

    @Override
    public Result delete(JobSeeker jobSeeker) {
        this.jobSeekerDao.delete(jobSeeker);
        return new SuccessResult("Job seeker is deleted. ");
    }

    @Override
    public Result update(JobSeeker jobSeeker) {
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Job seeker is updated .");
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerDao.findAll(), "Job seekers are listed");
    }

    @Override
    public DataResult<JobSeeker> getById(int id) {
        Optional<JobSeeker> getById = this.jobSeekerDao.findById(id);
        if (getById.isEmpty()) {
            return new ErrorDataResult<>("Job Seeker's id is not found");
        }
        return new SuccessDataResult<>(getById.get());
    }

    public Result arePasswordMatches(String password, String passwordRepeat) {
        if (password.equals(passwordRepeat)) {
            return new SuccessResult();
        }
        return new ErrorResult("Password and Confirm Password are not equals. ");
    }

    public Result isMernisVerificationValid() {
       Result isTrue =this.mernisVerificationService.check(new PersonVerificationFromMernis(personVerificationFromMernis.getIdendityNumber(),
                personVerificationFromMernis.getFirstName(),
                personVerificationFromMernis.getLastName(),
                personVerificationFromMernis.getBirthYear()
                ));
       if(isTrue.isSuccess()){
           return new SuccessResult("Mernis verificated. ");
       }
        return new ErrorResult("Mernis is not verified . ");
    }

}
