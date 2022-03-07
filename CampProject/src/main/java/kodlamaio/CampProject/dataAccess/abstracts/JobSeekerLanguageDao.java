package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.JobSeekerLanguage;
import kodlamaio.CampProject.entities.concretes.JobSeekerSchool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {

    Optional<JobSeekerLanguage> getByJobSeeker_Id(int jobSeekerId);
    Optional<JobSeekerLanguage> getByLanguage_Id(int languageId);

}