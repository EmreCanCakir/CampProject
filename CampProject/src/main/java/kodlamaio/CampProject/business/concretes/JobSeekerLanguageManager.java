package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.JobSeekerLanguageService;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlamaio.CampProject.entities.concretes.JobSeekerLanguage;
import kodlamaio.CampProject.entities.concretes.JobSeekerSchool;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerLanguageAddDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    private JobSeekerLanguageDao jobSeekerLanguageDao;
    private ModelMapper modelMapper;

    @Autowired
    public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao, ModelMapper modelMapper) {
        this.jobSeekerLanguageDao = jobSeekerLanguageDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<JobSeekerLanguage>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerLanguageDao.findAll());
    }

    @Override
    public DataResult<JobSeekerLanguage> getByJobSeekerId(int jobSeekerId) {
        if(!this.jobSeekerLanguageDao.getByJobSeeker_Id(jobSeekerId).isEmpty()){
            return new SuccessDataResult<>(this.jobSeekerLanguageDao.getByJobSeeker_Id(jobSeekerId).get());
        }
        return new ErrorDataResult<>("Job Seeker does not exist");
    }

    @Override
    public DataResult<JobSeekerLanguage> getByLanguageId(int languageId) {
        if(!this.jobSeekerLanguageDao.getByLanguage_Id(languageId).isEmpty()){
            return new SuccessDataResult<>(this.jobSeekerLanguageDao.getByLanguage_Id(languageId).get());
        }
        return new ErrorDataResult<>("Job Seeker does not exist");
    }

    @Override
    public Result addMultiple(List<JobSeekerLanguageAddDto> jobSeekerLanguageAddDto) {
        return null;
    }

    @Override
    public Result add(JobSeekerLanguageAddDto entity) {
        final Result businessRules = BusinessRules.run(getByJobSeekerId(entity.getJobSeekerId()),getByLanguageId(entity.getLanguageId()));
        if(!businessRules.isSuccess()){
            JobSeekerLanguage jobSeekerLanguage = modelMapper.map(entity,JobSeekerLanguage.class);
            this.jobSeekerLanguageDao.save(jobSeekerLanguage);
            return new SuccessResult();
        }
        return new ErrorResult("JobSeeker Language is already exist");
    }

    @Override
    public Result delete(JobSeekerLanguageAddDto entity) {
        final Result businessRules = BusinessRules.run(getByJobSeekerId(entity.getJobSeekerId()),getByLanguageId(entity.getLanguageId()));
        if(businessRules.isSuccess()){
            JobSeekerLanguage jobSeekerLanguage = modelMapper.map(entity,JobSeekerLanguage.class);
            this.jobSeekerLanguageDao.delete(jobSeekerLanguage);
            return new SuccessResult();
        }
        return new ErrorResult("JobSeeker Language does not exist");
    }

    @Override
    public Result update(JobSeekerLanguageAddDto entity) {
        final Result businessRules = BusinessRules.run(getByJobSeekerId(entity.getJobSeekerId()),getByLanguageId(entity.getLanguageId()));
        if(businessRules.isSuccess()){
            JobSeekerLanguage jobSeekerLanguage = modelMapper.map(entity,JobSeekerLanguage.class);
            this.jobSeekerLanguageDao.save(jobSeekerLanguage);
            return new SuccessResult();
        }
        return new ErrorResult("JobSeeker Language does not exist");
    }
}
