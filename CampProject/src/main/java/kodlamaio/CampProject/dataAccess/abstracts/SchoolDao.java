package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SchoolDao extends JpaRepository<School, Integer> {
    Optional<School> getBySchoolName(String schoolName);
    List<School> getBySchoolNameStartsWith(String schoolName);
}