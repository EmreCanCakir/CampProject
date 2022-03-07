package kodlamaio.CampProject.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerSkillAddDto {

    @NotNull(message = "required")
    private int jobSeekerId;

    @NotNull(message = "required")
    private int jobSeekerSkillId;

}
