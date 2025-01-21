package dietmaker.user.domain.entities;

import java.util.Date;
import java.util.UUID;

import dietmaker.user.domain.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private byte[] passwordHash;

    @Column(name = "password_salt")
    private byte[] passwordSalt;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "height_cm")
    private Double height;

    @Column(name = "weight_kg")
    private Double weight;

    @Column(name = "basal_metabolic_rate")
    private Double basalMetabolicRate;

    @Column(name = "activity_level_coefficient")
    private Double activityLevelCoefficient;

    public User(String userName, String email, byte[] passwordHash, byte[] passwordSalt, Date birthDate, Gender gender,
            Double height,
            Double weight,
            Double activityLevelCoefficient) {
        this.userName = userName;
        this.email = email;

        this.birthDate = birthDate;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activityLevelCoefficient = activityLevelCoefficient;
        this.basalMetabolicRate = 0.0;

        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
    }
}
