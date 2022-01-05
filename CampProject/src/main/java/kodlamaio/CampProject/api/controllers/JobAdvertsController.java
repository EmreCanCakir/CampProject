package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.JobAdvertService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertController")
public class JobAdvertsController {
    private JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvert>> getAll() {
        return this.jobAdvertService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvert jobAdvert) {
        return this.jobAdvertService.add(jobAdvert);
    }

    @GetMapping("findAllByEmployerId")
    public DataResult<List<JobAdvert>> findAllByEmployerId(@RequestParam int employerId) {
        return this.jobAdvertService.findAllByEmployerId(employerId);
    }

    @GetMapping("findAllActiveTrueAndVerifiedTrue")
    public DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrue() {
        return this.jobAdvertService.findAllByActiveTrueAndVerifiedTrue();
    }

    @GetMapping("findAllByActiveTrueAndVerifiedTrueSort")
    public DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrueSort(@RequestParam("sortNumber") int sortNumber) {
        return this.jobAdvertService.findAllByActiveTrueAndVerifiedTrueSort(sortNumber);
    }

    @GetMapping("findAllByActiveTrueAndVerifiedTrueAndEmployerId")
    public DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrueAndEmployerId(@RequestParam("employerId") int employerId) {
        return this.jobAdvertService.findAllByActiveTrueAndVerifiedTrueAndEmployerId(employerId);
    }

    @GetMapping("getAllByVerifiedFalse")
    public DataResult<List<JobAdvert>> getAllByVerifiedFalse(@RequestParam("sortNumber") int sortNumber) {
        return this.jobAdvertService.getAllByVerifiedFalse(sortNumber);
    }//navıgate bar

    @GetMapping("findAllByActiveTrueAndVerifiedTrueAndApplicationDeadlineBefore")
    public DataResult<List<JobAdvert>> findAllByActiveTrueAndVerifiedTrueAndApplicationDeadlineBefore(LocalDate date) {
        return this.jobAdvertService.findAllByActiveTrueAndVerifiedTrueAndApplicationDeadlineBefore(date);
    }

    @PutMapping("updateActivation")
    public ResponseEntity<?> updateActivation(@RequestParam("status") boolean status, @RequestParam("jobAdvertId") int jobAdvertId) {
        return UTILS.getResponseEntity(this.jobAdvertService.updateActivation(status, jobAdvertId));
    }
    @PutMapping("updateVerification")
    public ResponseEntity<?> updateVerification(@RequestParam("status") boolean status,@RequestParam("jobAdvertId") int jobAdvertId){
        return UTILS.getResponseEntity(this.jobAdvertService.updateVerification(status,jobAdvertId));
    }

}
