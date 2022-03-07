package kodlamaio.CampProject.entities.concretes.dtos;

import kodlamaio.CampProject.core.entities.UserAddDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemStaffDto extends UserAddDto {

    @NotBlank(message = "required")
    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "required")
    @NotNull
    @Size(max = 50)
    private String lastName;

}
