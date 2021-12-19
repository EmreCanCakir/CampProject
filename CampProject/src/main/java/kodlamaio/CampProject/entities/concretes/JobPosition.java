package kodlamaio.CampProject.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@Table(name = "job_positions")
@NoArgsConstructor
@AllArgsConstructor
public class JobPosition {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

}
