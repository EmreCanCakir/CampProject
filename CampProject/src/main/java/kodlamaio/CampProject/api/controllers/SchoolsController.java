package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.SchoolService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schools_controller")
public class SchoolsController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return UTILS.getResponseEntity(this.schoolService.getAll());
    }

    @GetMapping("/get_by_name_starts_with")
    public ResponseEntity<?> getByNameStartsWith(@RequestParam("schoolName") String schoolName){
        return UTILS.getResponseEntity(this.schoolService.getByNameStartsWith(schoolName));
    }
    @PostMapping("/add_school_name")
    public ResponseEntity<?> addSchoolName(@RequestParam String schoolName){
        return UTILS.getResponseEntity(this.schoolService.addSchoolName(schoolName));
    }
}
