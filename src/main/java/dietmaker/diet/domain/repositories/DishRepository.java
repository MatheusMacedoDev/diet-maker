package dietmaker.diet.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dietmaker.diet.domain.entities.Dish;

public interface DishRepository extends JpaRepository<Dish, Short> {
}
