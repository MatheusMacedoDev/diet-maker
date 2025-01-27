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
public class DietFood {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diet_food_id")
    private UUID dietFoodId;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "grams_quantity")
    private short gramsQuantity;

    public DietFood(Diet diet, Food food, short gramsQuantity) {
        this.diet = diet;
        this.food = food;
        this.gramsQuantity = gramsQuantity;
    }
}
