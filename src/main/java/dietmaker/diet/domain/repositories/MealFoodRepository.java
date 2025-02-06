package dietmaker.diet.domain.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import dietmaker.diet.domain.entities.Meal;
import dietmaker.diet.domain.entities.MealFood;

public interface MealFoodRepository extends JpaRepository<MealFood, UUID> {
    List<MealFood> findAllByMeal(Meal meal);
}
