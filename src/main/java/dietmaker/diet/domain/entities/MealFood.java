package dietmaker.diet.domain.entities;

import java.util.UUID;

import jakarta.persistence.Column;
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
@Table(name = "diet_foods")
@NoArgsConstructor
@Getter
public class MealFood {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diet_food_id")
    private UUID dietFoodId;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "grams_quantity")
    private short gramsQuantity;

    public MealFood(Meal meal, Food food, short gramsQuantity) {
        this.meal = meal;
        this.food = food;
        this.gramsQuantity = gramsQuantity;
    }
}
