package kodlamaio.CampProject.business.abstracts;


import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobSeekerSkill;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerSkillAddDto;

import java.util.List;

public interface JobSeekerSkillService extends BaseService<JobSeekerSkillAddDto> {

    DataResult<List<JobSeekerSkill>> getAll();

    DataResult<JobSeekerSkill> getByJobSeekerId(int jobSeekerId);

    DataResult<JobSeekerSkill> getBySkillId(int skillId);

    Result addMultiple(List<JobSeekerSkillAddDto> jobSeekerSkillAddDto);

}
