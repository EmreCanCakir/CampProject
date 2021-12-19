package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

}
