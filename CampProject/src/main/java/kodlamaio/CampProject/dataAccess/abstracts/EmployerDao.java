package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Optional<Employer> findByEmail(String email);
}
