package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.entities.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

    List<Department> getByDepartmentNameStartsWith(String name);
    Optional<Department> getByDepartmentName(String name);

}