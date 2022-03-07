package kodlamaio.CampProject.entities.concretes.dtos;

import kodlamaio.CampProject.entities.concretes.JobSeekerExperience;
import kodlamaio.CampProject.entities.concretes.JobSeekerLanguage;
import kodlamaio.CampProject.entities.concretes.JobSeekerSchool;
import kodlamaio.CampProject.entities.concretes.JobSeekerSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvAddDto {

    @NotNull(message = "required")
    private int jobSeekerId;

    @NotNull(message = "required")
    private List<JobSeekerLanguage> jobSeekerLanguagesId;

    @NotNull(message = "required")
    private List<JobSeekerSchool> jobSeekerSchoolsId;

    @NotNull(message = "required")
    private List<JobSeekerExperience> jobSeekerExperiencesId;

    @NotNull(message = "required")
    private List<JobSeekerSkill> jobSeekerSkillsId;

    @NotNull
    @NotBlank(message = "required")
    private String title;

    @NotNull
    @NotBlank(message = "required")
    private String coverLetter;
}
