package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.JobSeekerSchoolService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerSchoolAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobSeekerSchoolsController")
public class JobSeekerSchoolsController {
    private JobSeekerSchoolService jobSeekerSchoolService;

    @Autowired
    public JobSeekerSchoolsController(JobSeekerSchoolService jobSeekerSchoolService) {
        this.jobSeekerSchoolService = jobSeekerSchoolService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return UTILS.getResponseEntity(this.jobSeekerSchoolService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobSeekerSchoolAddDto jobSeekerSchoolAddDto){
        return UTILS.getResponseEntity(this.jobSeekerSchoolService.add(jobSeekerSchoolAddDto));
    }

    @PostMapping("/addMultiple")
    public ResponseEntity<?> addMultiple(@RequestBody List<JobSeekerSchoolAddDto> jobSeekerSchoolAddDto){
        return UTILS.getResponseEntity(this.jobSeekerSchoolService.addMultiple(jobSeekerSchoolAddDto));
    }

    @GetMapping("/getByJobSeekerId")
    public ResponseEntity<?> getByJobSeekerId(@RequestParam int jobSeekerId){
        return UTILS.getResponseEntity(this.jobSeekerSchoolService.getByJobSeekerId(jobSeekerId));
    }

    @GetMapping("/getByJobSeekerSchoolId")
    public ResponseEntity<?> getByJobSeekerSchoolId(@RequestParam int jobSeekerSchoolId){
        return UTILS.getResponseEntity(this.jobSeekerSchoolService.getBySchoolId(jobSeekerSchoolId));
    }
}
