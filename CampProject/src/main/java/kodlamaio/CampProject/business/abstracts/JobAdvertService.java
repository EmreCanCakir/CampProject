package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobAdvert;
import kodlamaio.CampProject.entities.concretes.dtos.JobAdvertDto;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertService extends BaseService<JobAdvertDto> {

    DataResult<List<JobAdvert>> getAll();

    DataResult<JobAdvert> getById(int id);

    Result findByJobAdvertName(String jobAdvertName);

    DataResult<List<JobAdvert>> findAllByEmployerId(int employerId);

    Result existsByCityIdAndJobPositionIdAndEmployerId(int cityId, int jobPositionId, int employerId);

    DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrue();

    DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrueSort(int sortNumber);

    DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrueAndEmployerId(int employerId);

    DataResult<List<JobAdvert>> getAllByVerifiedFalse(int sortNumber);

    DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrueAndApplicationDeadlineBefore(LocalDate date);

    Result updateActivation(boolean status, int jobAdvertId);

    Result updateVerification(boolean status, int jobAdvertId);

    //   Result updateLastModifiedAt(int id, LocalDateTime lastModifiedAt);

    //   Result updateMinSalary(int id, int minSalary);

    //   Result updateMaxSalary(int id, int maxSalary);

    //   Result updateDeadline(int id, LocalDate dateLine);

    //   Result applyChanges(int id);
}
