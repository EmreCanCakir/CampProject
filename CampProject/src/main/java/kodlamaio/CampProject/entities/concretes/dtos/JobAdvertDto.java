package kodlamaio.CampProject.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {

    private int id;

    @NotNull
    @NotBlank
    private String jobAdvertName;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private int jobPositionId;

    @NotNull
    @NotBlank
    private int cityId;

    @NotNull
    @NotBlank
    private int employerId;

    @NotNull
    @Positive(message = "This field is must positive")
    private double minSalary;

    @Positive(message = "This field is must positive")
    private double maxSalary;

    @NotNull
    private Date applicationDeadline;

    @NotNull
    @Positive(message = "This field is must positive")
    private int openPositionsAmount;

}
