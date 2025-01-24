package dietmaker.diet.domain.valueobjects;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Macronutrients {

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
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || getClass() != object.getClass())
            return false;

        Macronutrients macronutrients = (Macronutrients) object;

        return carbohydrates == macronutrients.carbohydrates
                || protein == macronutrients.protein
                || lipids == macronutrients.lipids;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carbohydrates, protein, lipids, kcal);
    }

}
