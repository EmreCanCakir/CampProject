package kodlamaio.CampProject.entities.concretes;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_adverts")
public class JobAdvert {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_advertisements_id_generator")
    @SequenceGenerator(name = "job_advertisements_id_generator", sequenceName = "job_advertisements_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "job_advert_name",nullable = false,length = 50)
    private String jobAdvertName;

    @Column(name = "description",nullable = false,length = 250)
    private String description;

    @ManyToOne()
    @JoinColumn(name = "job_position_id",nullable = false)
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name = "city_id",nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "employer_id",nullable = false)
    private Employer employer;

    @Column(name = "min_salary",nullable = true)
    private String minSalary;

    @Column(name = "max_salary",nullable = true)
    private String maxSalary;

    @Column(name = "created_at",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "application_deadline",nullable = false)
    private Date applicationDeadline;

    @Column(name = "is_active",nullable = false)
    private boolean active;

    @Column(name = "is_verified",nullable = false)
    private boolean verified;

    @Column(name = "open_positions_amount")
    private String openPositionsAmount;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;
}
