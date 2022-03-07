package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.JobSeekerSkillService;
import kodlamaio.CampProject.core.entities.ApiError;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.JobSeekerSkillDao;
import kodlamaio.CampProject.entities.concretes.JobSeekerSkill;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerSkillAddDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobSeekerSkillManager implements JobSeekerSkillService {
    private JobSeekerSkillDao jobSeekerSkillDao;
    private ModelMapper modelMapper;

    @Autowired
    public JobSeekerSkillManager(JobSeekerSkillDao jobSeekerSkillDao, ModelMapper modelMapper) {
        this.jobSeekerSkillDao = jobSeekerSkillDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<JobSeekerSkill>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerSkillDao.findAll());
    }

    @Override
    public DataResult<JobSeekerSkill> getByJobSeekerId(int jobSeekerId) {
        if (this.jobSeekerSkillDao.getByJobSeeker_Id(jobSeekerId).isEmpty()) {
            return new ErrorDataResult<>("Job Seeker Id is not found.");
        }
        return new SuccessDataResult<>(this.jobSeekerSkillDao.getByJobSeeker_Id(jobSeekerId).get());
    }

    @Override
    public DataResult<JobSeekerSkill> getBySkillId(int skillId) {
        if (jobSeekerSkillDao.getBySkill_Id(skillId).isEmpty()) {
            return new ErrorDataResult<>("Job Seeker skill id is not found. ");
        }
        return new SuccessDataResult<>(this.jobSeekerSkillDao.getBySkill_Id(skillId).get());
    }

    @Override
    public Result addMultiple(List<JobSeekerSkillAddDto> jobSeekerSkillAddDto) {
        int error = 0;
        Map<String, Object> errors = new LinkedHashMap<>();
        for (int i = 0; i < jobSeekerSkillAddDto.size(); i++) {
            final Result result = BusinessRules.run(getByJobSeekerId(jobSeekerSkillAddDto.get(i).getJobSeekerId()), getBySkillId(jobSeekerSkillAddDto.get(i).getJobSeekerSkillId()));
            if (result.isSuccess()) {
                JobSeekerSkill jobSeekerSkill = modelMapper.map(jobSeekerSkillAddDto.get(i), JobSeekerSkill.class);
                this.jobSeekerSkillDao.save(jobSeekerSkill);
            } else {
                errors.put(String.format("Skill[%d]", i), result);
                error++;
            }
        }
        if(error>0){
            return new ErrorDataResult<>(new ApiError(errors));
        }else {
            return new SuccessResult("Datas are added. ");
        }
    }

    @Override
    public Result add(JobSeekerSkillAddDto entity) {
        final Result businessRules = BusinessRules.run(getByJobSeekerId(entity.getJobSeekerId()), getBySkillId(entity.getJobSeekerSkillId()));
        if (!businessRules.isSuccess()) {
            JobSeekerSkill jobSeekerSkill = modelMapper.map(entity, JobSeekerSkill.class);
            this.jobSeekerSkillDao.save(jobSeekerSkill);
            return new SuccessResult();
        }
        return new ErrorResult("Job Seeker Skill is already exist. ");
    }

    @Override
    public Result delete(JobSeekerSkillAddDto entity) {
        final Result businessRules = BusinessRules.run(getByJobSeekerId(entity.getJobSeekerId()), getBySkillId(entity.getJobSeekerSkillId()));
        if (businessRules.isSuccess()) {
            JobSeekerSkill jobSeekerSkill = modelMapper.map(entity, JobSeekerSkill.class);
            this.jobSeekerSkillDao.delete(jobSeekerSkill);
            return new SuccessResult();
        }
        return new ErrorResult("Job Seeker Skill is not found. ");
    }

    @Override
    public Result update(JobSeekerSkillAddDto entity) {
        final Result businessRules = BusinessRules.run(getByJobSeekerId(entity.getJobSeekerId()), getBySkillId(entity.getJobSeekerSkillId()));
        if (businessRules.isSuccess()) {
            JobSeekerSkill jobSeekerSkill = modelMapper.map(entity, JobSeekerSkill.class);
            this.jobSeekerSkillDao.save(jobSeekerSkill);
            return new SuccessResult();
        }
        return new ErrorResult("Job Seeker Skill is not found. ");
    }
}
