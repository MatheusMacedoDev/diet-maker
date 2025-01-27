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
@Table(name = "diet_dishes")
@NoArgsConstructor
@Getter
public class DietDish {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diet_dish_id")
    private UUID dietDishId;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Column(name = "multiplier")
    private float multiplier;

    public DietDish(Diet diet, Dish dish, float multiplier) {
        this.diet = diet;
        this.dish = dish;
        this.multiplier = multiplier;
    }
}
