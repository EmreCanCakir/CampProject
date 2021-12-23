package kodlamaio.CampProject.entities.concretes;

import kodlamaio.CampProject.core.entities.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
public class Employer extends User {

    @Column(name = "company_name",nullable = false,length = 100,unique = true)
    private String companyName;

    @Column(name = "website",nullable = false,unique = true,length = 100)
    private String website;

    @Column(name = "phone_number",length = 11,nullable = false)
    private String phoneNumber;

}
