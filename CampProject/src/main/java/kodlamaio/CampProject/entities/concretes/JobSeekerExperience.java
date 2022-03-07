package kodlamaio.CampProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_experiences")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobSeekerExperience {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_experience_id_generator")
    @SequenceGenerator(name = "job_experience_id_generator", sequenceName = "job_experience_id_sequence")
    private int id;

    @Column(name = "work_place_name",nullable = false)
    private String workPlaceName;

    @Column(name = "start_year",nullable = false)
    private int startYear;

    @Column(name = "end_year")
    private int endYear;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    @JsonIgnoreProperties(value = {"jobSeekerSchools","jobSeekerExperiences","jobSeekerSkills","cvs","jobSeekerLanguages"})
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "job_position_id",nullable = false)
    @JsonIgnoreProperties(value = "jobAdverts")
    private JobPosition jobPosition;

}
