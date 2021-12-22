package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService extends BaseService<JobPosition> {
    DataResult<List<JobPosition>> getAll();
    Result add(JobPosition jobPosition);
    Result isNotExistJobPosition(String jobPositionName);
}
