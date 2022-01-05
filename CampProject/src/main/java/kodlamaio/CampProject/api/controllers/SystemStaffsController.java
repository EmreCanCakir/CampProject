package kodlamaio.CampProject.api.controllers;

import kodlamaio.CampProject.business.abstracts.SystemStaffService;
import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.core.utilities.results.SuccessDataResult;
import kodlamaio.CampProject.entities.concretes.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system_staffs")
public class SystemStaffsController {
    private SystemStaffService systemStaffService;

    @Autowired
    public SystemStaffsController(SystemStaffService systemStaffService) {
        this.systemStaffService = systemStaffService;
    }
    @GetMapping("/getall")
    public DataResult<List<SystemStaff>> getAll(){
        return this.systemStaffService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SystemStaff systemStaff){
        return this.systemStaffService.register(systemStaff);
    }


}
