package kodlamaio.CampProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.CampProject.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobSeeker extends User {
    @Column(name = "first_name",nullable = false,length = 100)
    private String firstName;

    @Column(name = "last_name",nullable = false,length = 100)
    private String lastName;

    @Column(name = "identity_number",nullable = false,unique = true,length = 11)
    private String identityNumber;

    @Column(name = "birthdate",nullable = false)
    private int birthDate;

    @Column(name = "github_account")
    private String githubAccount;

    @Column(name = "linkedin_account")
    private String linkedinAccount;

    @OneToMany(mappedBy = "jobSeeker")
    @JsonIgnoreProperties(value = "jobSeeker")
    private List<JobSeekerSchool> jobSeekerSchools;

    @OneToMany(mappedBy = "jobSeeker")
    @JsonIgnoreProperties(value = "jobSeeker")
    private List<JobSeekerLanguage> jobSeekerLanguages;

    @OneToMany(mappedBy = "jobSeeker")
    @JsonIgnoreProperties(value = "jobSeeker")
    private List<JobSeekerExperience> jobSeekerExperiences;

    @OneToMany(mappedBy = "jobSeeker")
    @JsonIgnoreProperties(value = "jobSeeker")
    private List<JobSeekerSkill> jobSeekerSkills;

    @OneToMany(mappedBy = "jobSeeker")
    @JsonIgnoreProperties(value = "jobSeeker")
    private List<Cv> cvs;
}
