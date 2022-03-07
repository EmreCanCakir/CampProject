package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.DepartmentService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/DepartmentsController")
public class DepartmentsController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return UTILS.getResponseEntity(this.departmentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam("department") String department){
        return UTILS.getResponseEntity(departmentService.add(department));
    }

    @GetMapping("/getByNameStartsWith")
    public ResponseEntity<?> getByNameStartsWith(@RequestParam("name") String name){
        return UTILS.getResponseEntity(this.departmentService.getByNameStartsWith(name));
    }

}