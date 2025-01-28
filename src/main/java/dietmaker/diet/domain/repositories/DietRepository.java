package dietmaker.diet.domain.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import dietmaker.diet.domain.entities.Diet;

public interface DietRepository extends JpaRepository<Diet, UUID> {
}
