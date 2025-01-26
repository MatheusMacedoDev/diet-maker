package dietmaker.diet.domain.entities;

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
@Table(name = "dishes")
@NoArgsConstructor
@Getter
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private short dishId;

    @Column(name = "dish_name")
    private String dishName;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "carbohydrates", column = @Column(name = "dish_carbohydrates")),
        @AttributeOverride(name = "protein", column = @Column(name = "dish_protein")),
        @AttributeOverride(name = "lipids", column = @Column(name = "dish_lipids")),
        @AttributeOverride(name = "kcal", column = @Column(name = "dish_kcal"))
    })
    private Macronutrients macronutrients;
}
