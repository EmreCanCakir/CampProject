package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.SkillService;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.SkillDao;
import kodlamaio.CampProject.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class SkillManager implements SkillService {
    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }


    @Override
    public Result add(Skill skill) {
        if(this.skillDao.findByName(skill.getName()).isEmpty()){
            return new ErrorResult("Skill name is already exist");
        }
        this.skillDao.save(skill);
        return new SuccessResult("Skill is added. ");
    }
    @Override
    public Result addSkillName(String skill){
        if(!this.skillDao.findByName(skill).isEmpty()){
            return new ErrorResult("Skill name is already exist");
        }
        this.skillDao.save(new Skill(skill.toUpperCase(Locale.ROOT)));
        return new SuccessResult("Skill is added. ");
    }

    @Override
    public Result delete(Skill skill) {
        if(!this.skillDao.findById(skill.getId()).isEmpty()){
            return new SuccessResult("Skill is deleted successfully. ");
        }
        return new ErrorResult("Skill is not deleted because skill is not existing. ");
    }

    @Override
    public Result update(Skill skill) {
        if(this.skillDao.findById(skill.getId()).isEmpty()){
            return new ErrorResult("Skill is not updated. ");
        }
        this.skillDao.save(skill);
        return new SuccessResult("Skill is updated. ");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<>(this.skillDao.findAll(),"Skills are listed. ");
    }

    @Override
    public DataResult<Skill> getById(int id) {
        return new SuccessDataResult<>(this.skillDao.getById(id));
    }

    @Override
    public DataResult<List<Skill>> getByNameStartsWith(String name) {
        return new SuccessDataResult<>(String.valueOf(this.skillDao.getByNameStartsWith(name.toUpperCase(Locale.ROOT))));
    }
}
