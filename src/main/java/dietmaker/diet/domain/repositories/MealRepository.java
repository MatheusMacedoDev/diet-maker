package dietmaker.diet.domain.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import dietmaker.diet.domain.entities.Diet;
import dietmaker.diet.domain.entities.Meal;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, UUID> {
    List<Meal> findAllByDiet(Diet diet);
}
