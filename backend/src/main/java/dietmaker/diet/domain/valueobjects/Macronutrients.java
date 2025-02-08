package dietmaker.diet.domain.valueobjects;

import java.util.List;

import dietmaker.diet.domain.entities.MealDish;
import dietmaker.diet.domain.entities.MealFood;
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
    private double fibers;
    private double kcal;

    public Macronutrients(double carbohydrates, double protein, double lipids, double fibers) {
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.lipids = lipids;
        this.fibers = fibers;

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
        return new Object[] { carbohydrates, protein, lipids, fibers, kcal };
    }

    public static Macronutrients calculateMealMacronutrients(List<MealFood> foods, List<MealDish> dishes) {
        double carbohydrates = 0;
        double protein = 0;
        double lipids = 0;
        double fibers = 0;

        for (MealFood food : foods) {
            carbohydrates += food.getFood().getMacronutrients().carbohydrates * food.getGramsQuantity();
            protein += food.getFood().getMacronutrients().protein * food.getGramsQuantity();
            lipids += food.getFood().getMacronutrients().lipids * food.getGramsQuantity();
            fibers += food.getFood().getMacronutrients().fibers * food.getGramsQuantity();
        }

        for (MealDish dish : dishes) {
            carbohydrates += dish.getDish().getMacronutrients().carbohydrates * dish.getMultiplier();
            protein += dish.getDish().getMacronutrients().protein * dish.getMultiplier();
            lipids += dish.getDish().getMacronutrients().lipids * dish.getMultiplier();
            fibers += dish.getDish().getMacronutrients().fibers * dish.getMultiplier();
        }

        return new Macronutrients(carbohydrates, protein, lipids, fibers);
    }

    public Macronutrients plus(Macronutrients other) {
        return new Macronutrients(
            carbohydrates + other.carbohydrates,
            protein + other.protein,
            lipids + other.lipids,
            fibers + other.fibers);
    }
}
