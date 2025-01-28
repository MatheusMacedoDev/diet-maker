package dietmaker.diet.domain.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import dietmaker.diet.domain.entities.DietDish;

public interface DietDishRepository extends JpaRepository<DietDish, UUID> {
}
