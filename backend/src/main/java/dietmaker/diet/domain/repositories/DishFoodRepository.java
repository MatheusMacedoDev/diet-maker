package dietmaker.diet.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dietmaker.diet.domain.entities.DishFood;

public interface DishFoodRepository extends JpaRepository<DishFood, Integer> {
}
