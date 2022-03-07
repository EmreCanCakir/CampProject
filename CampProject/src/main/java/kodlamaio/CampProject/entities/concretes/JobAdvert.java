package kodlamaio.CampProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)       //This provides to keep lastModifiedDate and creationTimeStamp values in [];
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_adverts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @ManyToOne
    @JoinColumn(name = "job_position_id",nullable = false)
    @JsonIgnoreProperties(value = {"jobAdverts"})
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name = "city_id",nullable = false)
    @JsonIgnoreProperties(value = {"jobAdverts"})
    private City city;

    @ManyToOne
    @JoinColumn(name = "employer_id",nullable = false)
    @JsonIgnoreProperties(value = {"jobAdverts","password","passwordRepeat","createdAt"})
    private Employer employer;

    @Column(name = "min_salary",nullable = true)
    private double minSalary;

    @Column(name = "max_salary",nullable = true)
    private double maxSalary;

    @Column(name = "created_at",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "application_deadline",nullable = false)
    private Date applicationDeadline;

    @Column(name = "is_active",nullable = false)
    private boolean active;

    @Column(name = "is_verified",nullable = true)
    private boolean verified;

    @Column(name = "open_positions_amount")
    private int openPositionsAmount;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;
}
