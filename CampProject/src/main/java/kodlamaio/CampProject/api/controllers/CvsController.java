package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.CvService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import kodlamaio.CampProject.entities.concretes.dtos.CvAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CvsController")
public class CvsController {

    private CvService cvService;

    @Autowired
    public CvsController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getByJobSeekerId")
    public ResponseEntity<?> getByJobSeekerId(@RequestParam int jobSeekerId){
        return UTILS.getResponseEntity(this.cvService.getByJobSeekerId(jobSeekerId));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam int id){
        return UTILS.getResponseEntity(this.cvService.getByJobSeekerId(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CvAddDto cvAddDto){
        return UTILS.getResponseEntity(this.cvService.add(cvAddDto));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam int id){
        return UTILS.getResponseEntity(this.cvService.deleteById(id));
    }

}
