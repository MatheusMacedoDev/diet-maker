package dietmaker.diet.domain.entities;

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
    private double foodName;

    @Column(name = "food_carbohydrates")
    private double foodCarbohydrates;

    @Column(name = "food_protein")
    private double foodProtein;

    @Column(name = "food_lipids")
    private double foodLipids;

    @Column(name = "food_kcal")
    private double foodKcal;
}
