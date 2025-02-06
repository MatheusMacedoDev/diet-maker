package dietmaker.diet.domain.entities;

import java.util.List;
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
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "mealId")
    private List<Meal> dietMeals;

    @Column(name = "diet_name")
    private String dietName;

    @Column(name = "diet_water_ml")
    private short dietWaterMl;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "carbohydrates", column = @Column(name = "diet_carbohydrates")),
        @AttributeOverride(name = "protein", column = @Column(name = "diet_protein")),
        @AttributeOverride(name = "lipids", column = @Column(name = "diet_lipids")),
        @AttributeOverride(name = "fibers", column = @Column(name = "diet_fibers")),
        @AttributeOverride(name = "kcal", column = @Column(name = "diet_kcal"))
    })
    private Macronutrients macronutrients;

    public Diet(String dietName, User user, short dietWaterMl) {
        this.dietName = dietName;
        this.user = user;
        this.macronutrients = new Macronutrients(0, 0, 0, 0);
        this.dietWaterMl = dietWaterMl;
    }

    public void setMacronutrients(Macronutrients macronutrients) {
        this.macronutrients = macronutrients;
    }
}
