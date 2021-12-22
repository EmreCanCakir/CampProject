package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.JobPositionService;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.JobPositionDao;
import kodlamaio.CampProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll(), "Job positions are listed");
    }

    @Override
    public DataResult<JobPosition> getById(int id) {
        final Optional<JobPosition> jobPosition = jobPositionDao.findById(id);
        if(jobPosition.isEmpty()){
            return new ErrorDataResult<>();
        }else {
            return new SuccessDataResult<>(jobPosition.get());
        }
    }

    @Override
    public Result add(JobPosition jobPosition) {
        final Result businessResult = BusinessRules.run(isNotExistJobPosition(jobPosition.getName()));
        if(!businessResult.isSuccess()){
            return businessResult;
        }else{
            this.jobPositionDao.save(jobPosition);
            return new SuccessResult("Job position is added . ");
        }
    }

    @Override
    public Result isNotExistJobPosition(String jobPositionName) {
        if(this.jobPositionDao.findByName(jobPositionName).isEmpty()){
            return new SuccessResult();
        }
        return new ErrorResult("Job position is already exist . ");
    }

    @Override
    public Result delete(final JobPosition jobPosition) {
        jobPositionDao.delete(jobPosition);
        return new SuccessResult("Job position is deleted. ");
    }

    @Override
    public Result update(final JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
        return new SuccessResult("Job position is updated. ");
    }
}
