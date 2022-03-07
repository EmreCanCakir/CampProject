package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.LanguageService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/languages_controller")
public class LanguagesController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return UTILS.getResponseEntity(this.languageService.getAll());
    }
    @GetMapping("getByNameStartsWith")
    public ResponseEntity<?> getByNameStartsWith(@RequestParam("language") String language){
        return UTILS.getResponseEntity(this.languageService.getByNameStartsWith(language));
    }

    @PostMapping("addLanguage")
    public ResponseEntity<?> addLanguage(@RequestParam("language") String language){
        return UTILS.getResponseEntity(this.languageService.addLanguage(language));
    }

}
