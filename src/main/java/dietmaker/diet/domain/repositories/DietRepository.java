package dietmaker.diet.domain.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import dietmaker.diet.domain.entities.Diet;
import java.util.List;
import dietmaker.user.domain.entities.User;

public interface DietRepository extends JpaRepository<Diet, UUID> {
    List<Diet> findAllByUser(User user);
}
