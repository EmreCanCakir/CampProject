package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityDao extends JpaRepository<City,Integer> {

    Optional<City> findByName(String name);
    List<City> getByNameStartsWith(String cityName);

}
