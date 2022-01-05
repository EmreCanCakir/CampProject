package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.business.abstracts.BaseService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.entities.concretes.City;

import java.util.List;

public interface CityService extends BaseService<City> {

    DataResult<List<City>> getByNameStartsWith(String name);

}
