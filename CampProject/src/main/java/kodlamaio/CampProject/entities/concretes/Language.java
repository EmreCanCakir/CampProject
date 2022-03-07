package kodlamaio.CampProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "languages_id_generator")
    @SequenceGenerator(name = "languages_id_generator",sequenceName = "languages_id_sequence", allocationSize = 1, initialValue = 30)
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false,unique = true, length = 50)
    private String name;

    public Language(String name) {
        this.name = name;
    }

}
