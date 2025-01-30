package dietmaker.diet.domain.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import dietmaker.diet.domain.entities.Diet;
import dietmaker.diet.domain.entities.DietFood;

public interface DietFoodRepository extends JpaRepository<DietFood, UUID> {
    List<DietFood> findAllByDiet(Diet diet);
}
