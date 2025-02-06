package dietmaker.diet.domain.entities;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import dietmaker.diet.domain.valueobjects.Macronutrients;
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
@Table(name = "meals")
@NoArgsConstructor
@Getter
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "meal_id")
    private UUID mealId;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @Column(name = "meal_name")
    private String mealName;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "carbohydrates", column = @Column(name = "meal_carbohydrates")),
        @AttributeOverride(name = "protein", column = @Column(name = "meal_protein")),
        @AttributeOverride(name = "lipids", column = @Column(name = "meal_lipids")),
        @AttributeOverride(name = "kcal", column = @Column(name = "meal_kcal"))
    })
    private Macronutrients macronutrients;

    @Column(name = "meal_time")
    private LocalTime mealTime;

    @OneToMany(mappedBy = "mealFoodId")
    private List<MealFood> mealFoods;

    @OneToMany(mappedBy = "mealDishId")
    private List<MealDish> mealDishes;

    public Meal(String mealName, Diet diet) {
        this.mealName = mealName;
        this.diet = diet;
        this.macronutrients = new Macronutrients(0, 0, 0);
    }

    public void setMacronutrients(Macronutrients macronutrients) {
        this.macronutrients = macronutrients;
    }
}
