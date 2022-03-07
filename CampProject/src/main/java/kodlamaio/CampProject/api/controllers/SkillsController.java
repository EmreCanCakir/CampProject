package kodlamaio.CampProject.api.controllers;


import kodlamaio.CampProject.business.abstracts.SkillService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import kodlamaio.CampProject.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills_controller")
public class SkillsController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return UTILS.getResponseEntity(this.skillService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam(value = "skill") String skill){
        return UTILS.getResponseEntity(this.skillService.addSkillName(skill));
    }

}
