package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
        Optional<JobSeeker> findByEmail(String email);
        Optional<JobSeeker> findByIdentityNumber(String identityNumber);
}
