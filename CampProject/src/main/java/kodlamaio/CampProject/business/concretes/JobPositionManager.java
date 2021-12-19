package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.JobPositionService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.core.utilities.results.SuccessDataResult;
import kodlamaio.CampProject.core.utilities.results.SuccessResult;
import kodlamaio.CampProject.dataAccess.abstracts.JobPositionDao;
import kodlamaio.CampProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll(), "İş pozisyonları listelendi");
    }

    @Override
    public DataResult<JobPosition> getById(int id) {
        return null;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Is pozisyonu eklendi . ");
    }

    @Override
    public Result delete(JobPosition entity) {
        return null;
    }

    @Override
    public Result update(JobPosition entity) {
        return null;
    }
}
