package dietmaker.diet.domain.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import dietmaker.diet.domain.entities.Diet;
import dietmaker.diet.domain.entities.DietDish;
import java.util.List;

public interface DietDishRepository extends JpaRepository<DietDish, UUID> {
    List<DietDish> findAllByDiet(Diet diet);
}
