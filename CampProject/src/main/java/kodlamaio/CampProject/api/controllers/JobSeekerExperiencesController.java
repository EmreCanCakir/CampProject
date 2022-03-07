package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.JobSeekerExperienceService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import kodlamaio.CampProject.entities.concretes.dtos.JobExperienceAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/JobSeekerExperiencesController")
public class JobSeekerExperiencesController {

    @Autowired
    private JobSeekerExperienceService jobSeekerExperienceService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return UTILS.getResponseEntity(this.jobSeekerExperienceService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobExperienceAddDto jobExperienceAddDto){
        return UTILS.getResponseEntity(this.jobSeekerExperienceService.add(jobExperienceAddDto));
    }

    @GetMapping("/getByPositionStartsWith")
    public ResponseEntity<?> getByPositionStartsWith(@RequestParam String jobPosition){
        return UTILS.getResponseEntity(this.jobSeekerExperienceService.getByPositionStartsWith(jobPosition));
    }

}
