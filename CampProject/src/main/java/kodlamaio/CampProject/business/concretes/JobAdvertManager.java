package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.JobAdvertService;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.CampProject.entities.concretes.JobAdvert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobAdvertManager implements JobAdvertService {
    private JobAdvertDao jobAdvertDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao) {
        this.jobAdvertDao = jobAdvertDao;
    }

    @Override
    public Result findByJobAdvertName(String jobAdvertName) {
        final Optional<JobAdvert> jobAdvert = this.jobAdvertDao.findByJobAdvertName(jobAdvertName);
        if (jobAdvert.isEmpty()) {
            return new ErrorResult("Job Advert name does not find");
        }
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvert>> findAllByEmployerId(int employerId) {
        return new SuccessDataResult<>(this.jobAdvertDao.findAllByEmployer_Id(employerId));
    }

    @Override
    public Result existsByCityIdAndJobPositionIdAndEmployerId(int cityId, int jobPositionId, int employerId) {
        if (!this.jobAdvertDao.existsByCity_IdAndJobPosition_IdAndEmployer_Id(cityId, jobPositionId, employerId).isSuccess()) {
            return new ErrorResult("Job Advert does not find");
        }
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrue() {
        return new SuccessDataResult<>(this.jobAdvertDao.findAllByActiveTrueAndVerifiedTrue());
    }

    @Override
    public DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrueSort(int sortNumber) {
        if (sortNumber == 0) {
            return new SuccessDataResult<>(this.jobAdvertDao.findAllByActiveTrueAndVerifiedTrueOrderByCreatedAtAsc());
        } else if (sortNumber == 1) {
            return new SuccessDataResult<>(this.jobAdvertDao.findAllByActiveTrueAndVerifiedTrueOrderByCreatedAtDesc());
        } else {
            return new ErrorDataResult<>();
        }
    }

    @Override
    public DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrueAndEmployerId(int employerId) {
        return new SuccessDataResult<>(this.jobAdvertDao.findAllByActiveTrueAndVerifiedTrueAndEmployer_Id(employerId));
    }

    @Override
    public DataResult<List<JobAdvert>> getAllByVerifiedFalse(int sortNumber) {
        if (sortNumber == 0) {
            return new SuccessDataResult<>(this.jobAdvertDao.getAllByVerifiedFalseOrderByCreatedAtAsc());
        } else if (sortNumber == 1) {
            return new SuccessDataResult<>(this.jobAdvertDao.getAllByVerifiedFalseOrderByCreatedAtDesc());
        } else {
            return new ErrorDataResult<>();
        }
    }

    @Override
    public DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrueAndApplicationDeadlineBefore(LocalDate date) {
        return new SuccessDataResult<>(this.jobAdvertDao.findAllByActiveTrueAndVerifiedTrueAndApplicationDeadlineBefore(date));
    }

    @Override
    public Result updateActivation(boolean status, int jobAdvertId) {
        JobAdvert jobAdvert = jobAdvertDao.getById(jobAdvertId);
        if (jobAdvert.isActive() == status) {
            return new ErrorResult("Please change your selection because same as before. ");
        } else {
            this.jobAdvertDao.updateActivation(status, jobAdvertId);
            return new SuccessResult();
        }

    }

    @Override
    public Result updateVerification(boolean status, int jobAdvertId) {
        JobAdvert jobAdvert = jobAdvertDao.getById(jobAdvertId);
        if (!jobAdvert.isVerified() == status) {
            return new ErrorResult("Please change your selection because same as before. ");
        } else {
            this.jobAdvertDao.updateVerified(status, jobAdvertId);
            return new SuccessResult();
        }

    }

    @Override
    public Result add(JobAdvert entity) {
        final Result result = BusinessRules.run(
          getById(entity.getId()),
          findByJobAdvertName(entity.getJobAdvertName()),
          existsByCityIdAndJobPositionIdAndEmployerId(entity.getCity().getId(),entity.getJobPosition().getId(),entity.getEmployer().getId())
        );
        if(!result.isSuccess()){
            return new ErrorResult("Job advert is already exist");
        }else {
            this.jobAdvertDao.save(entity);
            return new SuccessResult();
        }
    }

    @Override
    public Result delete(JobAdvert entity) {
        this.jobAdvertDao.delete(entity);
        return new SuccessResult();
    }

    @Override
    public Result update(JobAdvert entity) {
        this.jobAdvertDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvert>> getAll() {
        return new SuccessDataResult<>(this.jobAdvertDao.findAll());
    }

    @Override
    public DataResult<JobAdvert> getById(int id) {
        Optional<JobAdvert> jobAdvert = this.jobAdvertDao.findById(id);
        if(jobAdvert.isEmpty()){
            return new ErrorDataResult<>();
        }
        return new SuccessDataResult<>(jobAdvert.get());
    }
}
