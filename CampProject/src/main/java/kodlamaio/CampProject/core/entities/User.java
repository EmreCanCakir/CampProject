package kodlamaio.CampProject.core.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_generator")
    @SequenceGenerator(name = "users_id_generator", sequenceName = "users_id_seq", allocationSize = 1, initialValue = 10)
    private int id;

    @Column(name = "email",nullable = false,unique = true,length = 100)
    private String email;

    @Column(name= "password",nullable = false,length = 100)
    private String password;

    @Column(name = "password_repeat",nullable = false,length = 100)
    private String passwordRepeat;

    @Column(name = "is_active",nullable = true)
    private boolean isActive;

    @Column(name = "is_deleted",nullable = true)
    private boolean isDeleted;

    @Column(name = "created_at",nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

}
