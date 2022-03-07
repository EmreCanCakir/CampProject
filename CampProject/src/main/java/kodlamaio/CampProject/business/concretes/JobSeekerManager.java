package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.JobSeekerService;
import kodlamaio.CampProject.core.adapters.abstracts.MernisVerificationService;
import kodlamaio.CampProject.core.business.abstracts.UserCheckService;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.CampProject.entities.concretes.JobSeeker;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerAddDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private MernisVerificationService mernisVerificationService;
    private UserCheckService userCheckService;
    private ModelMapper modelMapper;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserCheckService userCheckService,MernisVerificationService mernisVerificationService,ModelMapper modelMapper) {
        this.jobSeekerDao = jobSeekerDao;
        this.userCheckService = userCheckService;
        this.mernisVerificationService = mernisVerificationService;
        this.modelMapper = modelMapper;
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
    public Result register(JobSeekerAddDto jobSeekerAddDto) {
        final Result businessRulesResult = BusinessRules.run(
                mernisVerificationService.check(jobSeekerAddDto.getIdentityNumber(),jobSeekerAddDto.getFirstName(),jobSeekerAddDto.getLastName(),jobSeekerAddDto.getBirthDate()),
                arePasswordMatches(jobSeekerAddDto.getPassword(), jobSeekerAddDto.getPasswordRepeat()),
                userCheckService.isValidEmail(jobSeekerAddDto.getEmail()),
                isNotIdentityNumberExist(jobSeekerAddDto.getIdentityNumber())
        );
        if (businessRulesResult.isSuccess()) {
            add(jobSeekerAddDto);
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
    public Result add(JobSeekerAddDto jobSeekerAddDto) {
        JobSeeker jobSeeker = modelMapper.map(jobSeekerAddDto,JobSeeker.class);
        final Result result = BusinessRules.run(isNotIdentityNumberExist(jobSeekerAddDto.getIdentityNumber()), isNotEmailExist(jobSeekerAddDto.getEmail()));
        if (!result.isSuccess()) {
            return new ErrorResult("Email or identity number is already exist. Job seeker is not added ");
        } else {
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult("Job Seeker is added");
        }
    }

    @Override
    public Result delete(JobSeekerAddDto jobSeekerAddDto) {
        JobSeeker jobSeeker = modelMapper.map(jobSeekerAddDto,JobSeeker.class);
        this.jobSeekerDao.delete(jobSeeker);
        return new SuccessResult("Job seeker is deleted. ");
    }

    @Override
    public Result update(JobSeekerAddDto jobSeekerAddDto) {
        JobSeeker jobSeeker = modelMapper.map(jobSeekerAddDto,JobSeeker.class);
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

}
