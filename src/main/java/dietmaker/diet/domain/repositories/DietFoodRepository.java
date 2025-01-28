package dietmaker.diet.domain.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import dietmaker.diet.domain.entities.DietFood;

public interface DietFoodRepository extends JpaRepository<DietFood, UUID> {
}
