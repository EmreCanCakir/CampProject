package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageDao extends JpaRepository<Image, Integer> {

    Optional<Image> getByPublicId(String publicId);

    Optional<Image> getByUser_Id(int userId);

    Result deleteById(int id);

    Result deleteByPublicId(String id);

}