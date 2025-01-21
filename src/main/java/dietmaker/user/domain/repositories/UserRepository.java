package dietmaker.user.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dietmaker.user.domain.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {
}
