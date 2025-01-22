package dietmaker.user.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dietmaker.user.domain.entities.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
