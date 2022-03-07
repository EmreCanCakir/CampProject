package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillDao extends JpaRepository<Skill,Integer> {
    Optional<Skill> findByName(String name);
    List<Skill> getByNameStartsWith(String skillName);
}
