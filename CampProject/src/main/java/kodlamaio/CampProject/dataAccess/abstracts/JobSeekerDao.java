package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

}
