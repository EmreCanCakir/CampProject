package kodlamaio.CampProject.entities.concretes;

import kodlamaio.CampProject.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class JobSeeker extends User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;


}
