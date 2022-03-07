package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.DepartmentService;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.DepartmentDao;
import kodlamaio.CampProject.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class DepartmentManager implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Result add(String department) {
        if(this.departmentDao.getByDepartmentName(department).isEmpty()){
            this.departmentDao.save(new Department(department.toUpperCase(Locale.ROOT)));
            return new SuccessResult();
        }
        return new ErrorResult();
    }

    @Override
    public DataResult<List<Department>> getByNameStartsWith(String department) {
        return new SuccessDataResult<>(this.departmentDao.getByDepartmentNameStartsWith(department.toUpperCase(Locale.ROOT)));
    }

    @Override
    public DataResult<List<Department>> getAll() {
        return new SuccessDataResult<>(this.departmentDao.findAll());
    }

    @Override
    public DataResult<Department> getById(int id) {
        return new SuccessDataResult<>(this.departmentDao.getById(id));
    }
}
