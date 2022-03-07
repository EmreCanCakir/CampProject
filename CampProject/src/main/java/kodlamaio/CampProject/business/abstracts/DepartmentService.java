package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {

    Result add(String department);

    DataResult<List<Department>> getByNameStartsWith(String department);

    DataResult<List<Department>> getAll();

    DataResult<Department> getById(int id);
}
