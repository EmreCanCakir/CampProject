package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
         Optional<JobPosition> findByName(String name);
}
