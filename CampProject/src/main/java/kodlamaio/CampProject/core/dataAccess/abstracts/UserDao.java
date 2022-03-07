package kodlamaio.CampProject.core.dataAccess.abstracts;

import kodlamaio.CampProject.core.entities.User;
import kodlamaio.CampProject.core.utilities.results.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    public Result existsByEmail(String email);
    public Result existsByEmailAndPassword(String email, String password);
}
