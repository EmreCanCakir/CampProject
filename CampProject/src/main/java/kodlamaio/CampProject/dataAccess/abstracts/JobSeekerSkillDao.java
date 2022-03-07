package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.JobSeekerSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSeekerSkillDao extends JpaRepository<JobSeekerSkill, Integer> {

    Optional<JobSeekerSkill> getByJobSeeker_Id(int jobSeekerId);
    Optional<JobSeekerSkill> getBySkill_Id(int skillId);
}