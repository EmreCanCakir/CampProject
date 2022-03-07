package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.JobSeekerExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience, Integer> {
    Optional<JobSeekerExperience> getByJobPosition_Name(String jobPositionName);
    List<JobSeekerExperience> getByJobPosition_NameStartsWith(String jobPositionName);
}