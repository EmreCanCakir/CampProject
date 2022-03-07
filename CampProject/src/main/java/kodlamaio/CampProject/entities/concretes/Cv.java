package kodlamaio.CampProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cvs_id_generator")
    @SequenceGenerator(name = "cvs_id_generator", sequenceName = "cvs_id_generator", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "cover_letter", nullable = false)
    private String coverLetter;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id", nullable = false)
    @JsonIgnoreProperties(value = {"jobSeekerSchools","jobSeekerLanguages","jobSeekerExperiences","jobSeekerSkills","cvs"})
    private JobSeeker jobSeeker;

    @ManyToMany
    @JoinTable(name = "cvs_languages",
            joinColumns = {@JoinColumn(name = "cv_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "job_seeker_language_id", referencedColumnName = "id")})
    @JsonIgnoreProperties(value = {"jobSeeker"})
    @ToString.Exclude
    private List<JobSeekerLanguage> jobSeekerLanguages;

    @ManyToMany
    @JoinTable(name = "cvs_schools",
            joinColumns = {@JoinColumn(name = "cv_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "job_seeker_school_id", referencedColumnName = "id")}
    )
    @JsonIgnoreProperties(value = {"jobSeeker"})
    @ToString.Exclude
    private List<JobSeekerSchool> jobSeekerSchools;

    @ManyToMany
    @JoinTable(name = "cvs_experiences",
            joinColumns = {@JoinColumn(name = "cv_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "job_seeker_experience_id", referencedColumnName = "id")}
    )
    @JsonIgnoreProperties(value = {"jobSeeker"})
    @ToString.Exclude
    private List<JobSeekerExperience> jobSeekerExperiences;

    @ManyToMany
    @JoinTable(name = "cvs_skills",
            joinColumns = {@JoinColumn(name = "cv_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "job_seeker_skill_id", referencedColumnName = "id")}
    )
    @JsonIgnoreProperties(value = {"jobSeeker"})
    @ToString.Exclude
    private List<JobSeekerSkill> jobSeekerSkills;
}
