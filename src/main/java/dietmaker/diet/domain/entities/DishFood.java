package dietmaker.diet.domain.entities;

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
@Table(name = "dish_foods")
@NoArgsConstructor
@Getter
public class DishFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_food_id")
    private int dishFoodId;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "grams_quantity")
    private short gramsQuantity;

    public DishFood(Dish dish, Food food, short gramsQuantity) {
        this.dish = dish;
        this.food = food;
        this.gramsQuantity = gramsQuantity;
    }
}
