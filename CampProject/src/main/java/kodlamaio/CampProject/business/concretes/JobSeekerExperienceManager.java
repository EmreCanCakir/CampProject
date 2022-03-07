package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.JobSeekerExperienceService;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.JobSeekerExperienceDao;
import kodlamaio.CampProject.entities.concretes.JobSeekerExperience;
import kodlamaio.CampProject.entities.concretes.dtos.JobExperienceAddDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerExperienceManager implements JobSeekerExperienceService {


    private ModelMapper modelMapper;
    private JobSeekerExperienceDao jobSeekerExperienceDao;

    @Autowired
    public JobSeekerExperienceManager(ModelMapper modelMapper, JobSeekerExperienceDao jobSeekerExperienceDao) {
        this.modelMapper = modelMapper;
        this.jobSeekerExperienceDao = jobSeekerExperienceDao;
    }


    @Override
    public DataResult<JobSeekerExperience> getById(int id) {
        return new SuccessDataResult<>(this.jobSeekerExperienceDao.getById(id));
    }

    @Override
    public DataResult<List<JobSeekerExperience>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerExperienceDao.findAll());
    }

    @Override
    public DataResult<List<JobSeekerExperience>> getByPositionStartsWith(String jobExperience) {
        return new SuccessDataResult<>(this.jobSeekerExperienceDao.getByJobPosition_NameStartsWith(jobExperience));
    }

    @Override
    public Result add(JobExperienceAddDto entity) {
        if(this.jobSeekerExperienceDao.findById(entity.getId()).isEmpty()){
            JobSeekerExperience jobSeekerExperience = modelMapper.map(entity,JobSeekerExperience.class);
            this.jobSeekerExperienceDao.save(jobSeekerExperience);
            return new SuccessResult("Job experience is added.");
        }
        return new ErrorResult("Job experience is not added because it is already exist. ");
    }

    @Override
    public Result delete(JobExperienceAddDto entity) {
        if(!this.jobSeekerExperienceDao.findById(entity.getId()).isEmpty()){
            JobSeekerExperience jobSeekerExperience = modelMapper.map(entity,JobSeekerExperience.class);
            this.jobSeekerExperienceDao.delete(jobSeekerExperience);
            return new SuccessResult("Job experience is deleted. ");
        }
        return new ErrorResult("Job experience is not deleted because it is not exist. ");
    }

    @Override
    public Result update(JobExperienceAddDto entity) {
        if(!this.jobSeekerExperienceDao.findById(entity.getId()).isEmpty()){
            JobSeekerExperience jobSeekerExperience = modelMapper.map(entity,JobSeekerExperience.class);
            this.jobSeekerExperienceDao.save(jobSeekerExperience);
            return new SuccessResult("Job experience is updated.");
        }
        return new ErrorResult("Job experience is not updated because it is not exist. ");
    }
}
