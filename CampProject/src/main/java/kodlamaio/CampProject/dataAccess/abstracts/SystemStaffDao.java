package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.business.abstracts.SystemStaffService;
import kodlamaio.CampProject.entities.concretes.SystemStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemStaffDao extends JpaRepository<SystemStaff,Integer> {
    Optional<SystemStaff> findByEmail(String email);

}
