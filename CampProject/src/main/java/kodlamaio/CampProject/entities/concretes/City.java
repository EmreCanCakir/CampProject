package kodlamaio.CampProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class City {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cities_id_generator")
    @SequenceGenerator(name = "cities_id_generator", sequenceName = "cities_id_sequence", allocationSize = 1, initialValue = 82)
    private int id;

    @Column(name = "name", nullable = false,unique = true,length = 50)
    private String name;

    @OneToMany(mappedBy = "city")
    @JsonIgnoreProperties(value = "city")
    @JsonIgnore
    private List<JobAdvert> jobAdverts;
}
