package dietmaker.diet.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dietmaker.diet.domain.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Short> {
}
