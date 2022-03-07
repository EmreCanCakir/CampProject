package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.JobSeekerLanguageService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerLanguageAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobSeekerLanguagesController")
public class JobSeekerLanguagesController {
    @Autowired
    private JobSeekerLanguageService jobSeekerLanguageService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return UTILS.getResponseEntity(this.jobSeekerLanguageService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobSeekerLanguageAddDto jobSeekerLanguageAddDto){
        return UTILS.getResponseEntity(this.jobSeekerLanguageService.add(jobSeekerLanguageAddDto));
    }

    @PostMapping("/addMultiple")
    public ResponseEntity<?> addMultiple(@RequestBody List<JobSeekerLanguageAddDto> jobSeekerLanguageAddDtos){
        return UTILS.getResponseEntity(this.jobSeekerLanguageService.addMultiple(jobSeekerLanguageAddDtos));
    }

    @GetMapping("/getByJobSeekerId")
    public ResponseEntity<?> getByJobSeekerId(@RequestParam int jobSeekerId){
        return UTILS.getResponseEntity(this.jobSeekerLanguageService.getByJobSeekerId(jobSeekerId));
    }

    @GetMapping("/getByLanguageId")
    public ResponseEntity<?> getByLanguageId(@RequestParam int languageId){
        return UTILS.getResponseEntity(this.jobSeekerLanguageService.getByLanguageId(languageId));
    }
}
