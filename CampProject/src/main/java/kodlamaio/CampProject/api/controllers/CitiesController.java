package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.CityService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city_controller")
public class CitiesController {
    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody City city) {
        return this.cityService.add(city);
    }

    @GetMapping("/getAll")
    public DataResult<List<City>> getAll() {
        return this.cityService.getAll();
    }

    @GetMapping("/getByNameStartsWith")
    public DataResult<List<City>> getByNameStartsWith(@RequestParam("name") String name) {
        return this.cityService.getByNameStartsWith(name);
    }

    @GetMapping("/getById")
    public DataResult<City> getById(@RequestParam("id") int id){
        return this.cityService.getById(id);
    }

}
