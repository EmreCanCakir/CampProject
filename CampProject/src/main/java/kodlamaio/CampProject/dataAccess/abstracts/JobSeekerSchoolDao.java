package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.JobSeekerSchool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSeekerSchoolDao extends JpaRepository<JobSeekerSchool, Integer> {
    Optional<JobSeekerSchool> getByJobSeeker_Id(int jobSeekerId);
    Optional<JobSeekerSchool> getBySchool_Id(int schoolId);
}