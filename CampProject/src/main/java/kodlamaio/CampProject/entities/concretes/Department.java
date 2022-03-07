package kodlamaio.CampProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_generator")
    @SequenceGenerator(name = "department_id_generator", sequenceName = "department_id_sequence", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "department_name", unique = true, length = 100)
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }


}
