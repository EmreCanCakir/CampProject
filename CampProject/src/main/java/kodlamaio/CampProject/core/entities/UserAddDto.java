package kodlamaio.CampProject.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddDto {
    @NotNull(message = "required")
    @NotBlank
    @Email
    private String email;

    @NotBlank(message = "required")
    @NotNull
    @Size(min = 6, max = 18, message = "size should be min {min} between {max}")
    private String password;

    @NotBlank(message = "required")
    @NotNull
    @Size(min = 6, max = 18, message = "size should be min {min} between {max}")
    private String passwordRepeat;
}
