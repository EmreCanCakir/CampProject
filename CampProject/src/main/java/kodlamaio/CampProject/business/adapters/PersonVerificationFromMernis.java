package kodlamaio.CampProject.business.adapters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonVerificationFromMernis {

    private long idendityNumber;
    private String firstName;
    private String lastName;
    private int birthYear;
}
