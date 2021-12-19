package kodlamaio.CampProject.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name= "password")
    private String password;

    @Column(name = "password_repeat")
    private String passwordRepeat;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_deleted")
    private boolean isDeleted;


}
