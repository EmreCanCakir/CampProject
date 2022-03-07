package kodlamaio.CampProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "job_seeker_skill")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobSeekerSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_seeker_skill_id_generator")
    @SequenceGenerator(name = "job_seeker_skill_id_generator", sequenceName = "job_seeker_skill_id_sequence", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id",nullable = false)
    @JsonIgnoreProperties(value = {"jobSeekerSchools","jobSeekerExperiences","jobSeekerSkills","cvs","jobSeekerLanguages"})
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false,unique = true)
    private Skill skill;

}
