package kodlamaio.CampProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "job_seeker_school",uniqueConstraints = {@UniqueConstraint(columnNames = {"job_seeker_id", "department_id", "school_id"})})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobSeekerSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_seeker_id_generator")
    @SequenceGenerator(name = "job_seeker_id_generator",sequenceName = "job_seeker_id_sequence",allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "is_graduate",nullable = false)
    private boolean isGraduate;

    @Column(name = "start_year",nullable = false)
    private int startYear;

    @Column(name = "graduation_year",nullable = true)
    private int graduationYear;

    @ManyToOne
    @JoinColumn(name = "school_id",nullable = false)
    private School school;

    @ManyToOne
    @JoinColumn(name = "department_id",nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id", nullable = false)
    @JsonIgnoreProperties(value = {"jobSeekerSchools","jobSeekerExperiences","jobSeekerSkills","cvs","jobSeekerLanguages"})
    private JobSeeker jobSeeker;

}
