package dietmaker.diet.domain.entities;

import dietmaker.diet.application.contracts.requests.FoodRequestDTO;
import jakarta.persistence.Column;
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

    @Column(name = "food_carbohydrates")
    private double foodCarbohydrates;

    @Column(name = "food_protein")
    private double foodProtein;

    @Column(name = "food_lipids")
    private double foodLipids;

    @Column(name = "food_kcal")
    private double foodKcal;

    public Food(FoodRequestDTO request) {
        this.foodName = request.name();

        this.foodCarbohydrates = request.carbohydrates();
        this.foodProtein = request.protein();
        this.foodLipids = request.lipids();

        this.foodKcal = foodCarbohydrates * 4 + foodProtein * 4 + foodLipids * 9;
    }
}
