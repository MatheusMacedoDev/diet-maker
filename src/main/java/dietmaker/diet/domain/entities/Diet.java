package dietmaker.diet.domain.entities;

import java.util.UUID;

import dietmaker.diet.domain.valueobjects.Macronutrients;
import dietmaker.user.domain.entities.User;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diets")
@NoArgsConstructor
@Getter
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diet_id")
    private UUID dietId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "diet_name")
    private String dietName;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "carbohydrates", column = @Column(name = "diet_carbohydrates")),
        @AttributeOverride(name = "protein", column = @Column(name = "diet_protein")),
        @AttributeOverride(name = "lipids", column = @Column(name = "diet_lipids")),
        @AttributeOverride(name = "kcal", column = @Column(name = "diet_kcal"))
    })
    private Macronutrients macronutrients;
}
