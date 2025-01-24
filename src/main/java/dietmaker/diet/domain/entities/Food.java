package dietmaker.diet.domain.entities;

import dietmaker.diet.application.contracts.requests.FoodRequestDTO;
import dietmaker.diet.domain.valueobjects.Macronutrients;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foods")
@NoArgsConstructor
@Getter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private short foodId;

    @Column(name = "food_name")
    private String foodName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "carbohydrates", column = @Column(name = "food_carbohydrates")),
            @AttributeOverride(name = "protein", column = @Column(name = "food_protein")),
            @AttributeOverride(name = "lipids", column = @Column(name = "food_lipids")),
            @AttributeOverride(name = "kcal", column = @Column(name = "food_kcal"))
    })
    private Macronutrients macronutrients;

    public Food(FoodRequestDTO request) {
        this.foodName = request.name();

        this.macronutrients = new Macronutrients(
                request.carbohydrates(),
                request.protein(),
                request.lipids());
    }
}
