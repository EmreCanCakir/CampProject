package kodlamaio.CampProject.entities.concretes;

import kodlamaio.CampProject.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "corporate_email")
    private String corporateEmail;

}
