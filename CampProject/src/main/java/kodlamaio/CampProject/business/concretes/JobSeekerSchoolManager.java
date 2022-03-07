package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.JobSeekerSchoolService;
import kodlamaio.CampProject.core.entities.ApiError;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.JobSeekerSchoolDao;
import kodlamaio.CampProject.entities.concretes.JobSeekerSchool;
import kodlamaio.CampProject.entities.concretes.JobSeekerSkill;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerSchoolAddDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobSeekerSchoolManager implements JobSeekerSchoolService {

    private JobSeekerSchoolDao jobSeekerSchoolDao;
    private ModelMapper modelMapper;

    @Autowired
    public JobSeekerSchoolManager(JobSeekerSchoolDao jobSeekerSchoolDao, ModelMapper modelMapper) {
        this.jobSeekerSchoolDao = jobSeekerSchoolDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<JobSeekerSchool>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerSchoolDao.findAll());
    }

    @Override
    public DataResult<JobSeekerSchool> getByJobSeekerId(int jobSeekerId) {
        if(this.jobSeekerSchoolDao.getByJobSeeker_Id(jobSeekerId).isEmpty()){
            return new ErrorDataResult<>("Job Seeker id is not found");
        }
        return new SuccessDataResult<>(this.jobSeekerSchoolDao.getByJobSeeker_Id(jobSeekerId).get());
    }

    @Override
    public DataResult<JobSeekerSchool> getBySchoolId(int schoolId) {
        if(this.jobSeekerSchoolDao.getBySchool_Id(schoolId).isEmpty()){
            return new ErrorDataResult<>("Job seeker school id is not found");
        }
        return new SuccessDataResult<>(this.jobSeekerSchoolDao.getBySchool_Id(schoolId).get());
    }

    @Override
    public Result addMultiple(List<JobSeekerSchoolAddDto> jobSeekerSchoolAddDto) {
        int error = 0;
        Map<String, Object> errors = new LinkedHashMap<>();
        for (int i = 0; i < jobSeekerSchoolAddDto.size(); i++) {
            final Result result = BusinessRules.run(getByJobSeekerId(jobSeekerSchoolAddDto.get(i).getJobSeekerId()), getBySchoolId(jobSeekerSchoolAddDto.get(i).getSchoolId()));
            if (result.isSuccess()) {
                JobSeekerSchool jobSeekerSchool = modelMapper.map(jobSeekerSchoolAddDto.get(i), JobSeekerSchool.class);
                this.jobSeekerSchoolDao.save(jobSeekerSchool);
            } else {
                errors.put(String.format("School[%d]", i), result);
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
    public Result add(JobSeekerSchoolAddDto entity) {
        final Result businessRules = BusinessRules.run(getByJobSeekerId(entity.getJobSeekerId()),getBySchoolId(entity.getSchoolId()));
        if(!businessRules.isSuccess()){
            JobSeekerSchool jobSeekerSchool = modelMapper.map(entity,JobSeekerSchool.class);
            this.jobSeekerSchoolDao.save(jobSeekerSchool);
            return new SuccessResult();
        }
        return new ErrorResult("Job seeker school is already exist.");
    }

    @Override
    public Result delete(JobSeekerSchoolAddDto entity) {
        final Result businessRules = BusinessRules.run(getByJobSeekerId(entity.getJobSeekerId()),getBySchoolId(entity.getSchoolId()));
        if(businessRules.isSuccess()){
            JobSeekerSchool jobSeekerSchool = modelMapper.map(entity,JobSeekerSchool.class);
            this.jobSeekerSchoolDao.delete(jobSeekerSchool);
            return new SuccessResult();
        }
        return new ErrorResult("Job seeker school does not exist.");
    }

    @Override
    public Result update(JobSeekerSchoolAddDto entity) {
        final Result businessRules = BusinessRules.run(getByJobSeekerId(entity.getJobSeekerId()),getBySchoolId(entity.getSchoolId()));
        if(businessRules.isSuccess()){
            JobSeekerSchool jobSeekerSchool = modelMapper.map(entity,JobSeekerSchool.class);
            this.jobSeekerSchoolDao.save(jobSeekerSchool);
            return new SuccessResult();
        }
        return new ErrorResult("Job seeker school does not exist.");
    }
}
