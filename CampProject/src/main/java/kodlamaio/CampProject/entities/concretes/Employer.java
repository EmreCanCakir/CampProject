package kodlamaio.CampProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.CampProject.core.entities.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User {

    @Column(name = "company_name",nullable = false,length = 100,unique = true)
    private String companyName;

    @Column(name = "website",nullable = false,unique = true,length = 100)
    private String website;

    @Column(name = "phone_number",length = 11,nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "employer",fetch = FetchType.EAGER)
    private List<JobAdvert> jobAdverts;

}
