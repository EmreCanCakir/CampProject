package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.CityService;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.CityDao;
import kodlamaio.CampProject.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
        if (!this.cityDao.findByName(city.getName()).isEmpty()) {
            return new ErrorResult("City is already exist so you can't add this city");
        }
        return new SuccessResult();
    }

    @Override
    public Result delete(City city) {
        if (this.cityDao.findByName(city.getName()).isEmpty()) {
            return new ErrorResult("City is not exist so you can't delete it. ");
        }
        this.cityDao.delete(city);
        return new SuccessResult();
    }

    @Override
    public Result update(City city) {
        if (this.cityDao.findByName(city.getName()).isEmpty()) {
            return new ErrorResult("City is not exist so you can't update it. ");
        }
        this.cityDao.save(city);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<>(this.cityDao.findAll(), "Cities are listed. ");
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<>(this.cityDao.getById(id));
    }

    @Override
    public DataResult<List<City>> getByNameStartsWith(String name) {
        return new SuccessDataResult<List<City>>(this.cityDao.getByNameStartsWith(name), "Data are listed. ");
    }
}
