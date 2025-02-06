package dietmaker.diet.domain.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import dietmaker.diet.domain.entities.Meal;
import dietmaker.diet.domain.entities.MealDish;
import java.util.List;

public interface MealDishRepository extends JpaRepository<MealDish, UUID> {
    List<MealDish> findAllByMeal(Meal meal);
}
