package kodlamaio.CampProject.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerSchoolAddDto {

    @NotNull(message = "required")
    private int jobSeekerId;

    @NotNull(message = "required")
    private int schoolId;

    @NotNull(message = "required")
    private int departmentId;

    @NotNull(message = "required")
    @Min(value = 1950, message = "It can not be smaller than min")
    @Max(value = 2022, message = "It can not be greater than max")
    private int startYear;

    @Min(value = 1950, message = "It can not be smaller than min")
    @Max(value = 2022, message = "It can not be greater than max")
    private int graduationYear;

}

