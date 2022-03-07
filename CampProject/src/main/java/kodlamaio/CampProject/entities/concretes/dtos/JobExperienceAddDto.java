package kodlamaio.CampProject.entities.concretes.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceAddDto {

    @NotNull
    @JsonIgnore
    private int id;

    @NotNull
    private int jobSeekerId;

    @NotNull
    private int jobPositionId;

    @NotNull
    @NotBlank(message = "required")
    private String workPlaceName;

    @NotNull
    @Min(value = 1950, message = "It can not be smaller than min")
    @Max(value = 2022, message = "It can not be greater than max")
    private int startYear;

    @NotNull
    @Min(value = 1950, message = "It can not be smaller than min")
    @Max(value = 2022, message = "It can not be greater than max")
    private int endYear;
}
