package dietmaker.diet.domain.valueobjects;

import java.util.List;

import dietmaker.diet.domain.entities.DietDish;
import dietmaker.diet.domain.entities.DietFood;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import util.ValueObject;

@Embeddable
@NoArgsConstructor
@Getter
public class Macronutrients extends ValueObject {

    private double carbohydrates;
    private double protein;
    private double lipids;
    private double kcal;

    public Macronutrients(double carbohydrates, double protein, double lipids) {
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.lipids = lipids;

        this.kcal = calculateTotalKcal();
    }

    private double calculateTotalKcal() {
        double carbohydratesKcal = carbohydrates * 4;
        double proteinKcal = protein * 4;
        double lipidsKcal = lipids * 9;

        return carbohydratesKcal + proteinKcal + lipidsKcal;
    }

    @Override
    protected Object getEqualityComponents() {
        return new Object[] { carbohydrates, protein, lipids, kcal };
    }

    public static Macronutrients calculateDietMacronutrients(List<DietFood> foods, List<DietDish> dishes) {
        short carbohydrates = 0;
        short protein = 0;
        short lipids = 0;

        for (DietFood food : foods) {
            carbohydrates += food.getFood().getMacronutrients().carbohydrates * food.getGramsQuantity();
            protein += food.getFood().getMacronutrients().protein * food.getGramsQuantity();
            lipids += food.getFood().getMacronutrients().lipids * food.getGramsQuantity();
        }

        for (DietDish dish : dishes) {
            carbohydrates += dish.getDish().getMacronutrients().carbohydrates * dish.getMultiplier();
            protein += dish.getDish().getMacronutrients().protein * dish.getMultiplier();
            lipids += dish.getDish().getMacronutrients().lipids * dish.getMultiplier();
        }

        return new Macronutrients(carbohydrates, protein, lipids);
    }

}
