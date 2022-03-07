package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.JobSeekerSkillService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerSkillAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/JobSeekerSkillsController")
public class JobSeekerSkillsController {

    @Autowired
    private JobSeekerSkillService jobSeekerSkillService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return UTILS.getResponseEntity(this.jobSeekerSkillService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobSeekerSkillAddDto jobSeekerSkillAddDto){
        return UTILS.getResponseEntity(this.jobSeekerSkillService.add(jobSeekerSkillAddDto));
    }

    @PostMapping("/addMultiple")
    public ResponseEntity<?> addMultiple(@RequestBody List<JobSeekerSkillAddDto> jobSeekerSkillAddDtos){
        return UTILS.getResponseEntity(this.jobSeekerSkillService.addMultiple(jobSeekerSkillAddDtos));
    }


    @GetMapping("/getByJobSeekerId")
    public ResponseEntity<?> getByJobSeekerId(@RequestParam("jobSeekerId") int jobSeekerId){
        return UTILS.getResponseEntity(this.jobSeekerSkillService.getByJobSeekerId(jobSeekerId));
    }

    @GetMapping("/getByJobSeekerSkillId")
    public ResponseEntity<?> getByJobSeekerSkillId(@RequestParam("jobSeekerSkillId") int jobSeekerSkillId){
        return UTILS.getResponseEntity(this.jobSeekerSkillService.getBySkillId(jobSeekerSkillId));
    }


}
