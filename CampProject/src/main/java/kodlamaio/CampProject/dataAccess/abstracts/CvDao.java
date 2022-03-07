package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CvDao extends JpaRepository<Cv, Integer> {

    Optional<Cv> getByJobSeeker_Id(int jobSeekerId);
 /*   Optional<Cv> getAllByJobSeekerExperiences();
    Optional<Cv> getAllByJobSeekerSchools();
    Optional<Cv> getAllByJobSeekerSkills();
    Optional<Cv> getAllByJobSeekerLanguages();
    */
}