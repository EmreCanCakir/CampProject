package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.ImageService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/imagesController")
public class ImagesController {

    private ImageService imageService;

    @Autowired
    public ImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam int id){
        return UTILS.getResponseEntity(this.imageService.getById(id));
    }

    @GetMapping("/getByPublicId")
    public ResponseEntity<?> getByPublicId(String publicId){
        return UTILS.getResponseEntity(this.imageService.getByPublicId(publicId));
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile,@RequestParam int id){
        return UTILS.getResponseEntity(imageService.upload(multipartFile,id));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam int id){
        return UTILS.getResponseEntity(this.imageService.deleteById(id));
    }

    @DeleteMapping("/deleteByPublicId")
    public ResponseEntity<?> deleteByPublicId(@RequestParam int publicId) {
        return UTILS.getResponseEntity(this.imageService.deleteById(publicId));
    }

}
