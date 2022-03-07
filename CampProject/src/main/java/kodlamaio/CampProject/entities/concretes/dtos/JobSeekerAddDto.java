package kodlamaio.CampProject.entities.concretes.dtos;

import kodlamaio.CampProject.core.entities.UserAddDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerAddDto extends UserAddDto {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 2,max = 50)
    private String lastName;

    @NotNull
    @NotBlank
    private String identityNumber;

    @NotNull
    @NotBlank
    private int birthDate;
}
