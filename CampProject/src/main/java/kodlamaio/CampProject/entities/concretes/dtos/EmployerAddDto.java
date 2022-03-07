package kodlamaio.CampProject.entities.concretes.dtos;

import kodlamaio.CampProject.core.entities.UserAddDto;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerAddDto extends UserAddDto {
    @NotNull(message = "required")
    @NotBlank
    private String companyName;

    @NotNull(message = "required")
    @NotBlank
    private String website;

    @NotNull(message = "required")
    @NotBlank
    private String phoneNumber;
}
