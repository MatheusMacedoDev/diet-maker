package dietmaker.diet.domain.valueobjects;

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

}
