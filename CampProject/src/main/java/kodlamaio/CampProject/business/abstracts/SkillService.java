package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.City;
import kodlamaio.CampProject.entities.concretes.Skill;

import java.util.List;

public interface SkillService extends BaseService<Skill> {

    DataResult<List<Skill>> getAll();
    DataResult<Skill> getById(int id);
    DataResult<List<Skill>> getByNameStartsWith(String name);
    Result addSkillName(String skill);

}
