package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.EmployerService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.Employer;
import kodlamaio.CampProject.entities.concretes.dtos.EmployerAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();

    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployerAddDto employerAddDto){
        return this.employerService.register(employerAddDto);
    }
}
