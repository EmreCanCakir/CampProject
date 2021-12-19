package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
