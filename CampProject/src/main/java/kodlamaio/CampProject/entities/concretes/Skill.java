package kodlamaio.CampProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "skill")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_id_generator")
    @SequenceGenerator(name = "skill_id_generator", sequenceName = "skill_id_sequence", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    public Skill(String name) {
        this.name = name;
    }
}
