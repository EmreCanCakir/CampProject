package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.JobSeekerService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobSeeker;
import kodlamaio.CampProject.entities.concretes.dtos.JobSeekerAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job_seekers")
public class JobSeekersController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }
    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll(){
        return this.jobSeekerService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerAddDto jobSeekerAddDto){
        return this.jobSeekerService.register(jobSeekerAddDto);
    }


}
