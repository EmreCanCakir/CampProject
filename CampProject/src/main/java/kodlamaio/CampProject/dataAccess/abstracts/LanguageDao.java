package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LanguageDao extends JpaRepository<Language, Integer> {
    Optional<Language> getByName(String name);
    List<Language> getByNameStartsWith(String name);
}