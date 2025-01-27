package dietmaker.diet.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dietmaker.diet.domain.entities.Dish;

public interface DishRepository extends JpaRepository<Dish, Short> {
    @Query(value = """
            SELECT * from dishes AS F
            WHERE SIMILARITY(F.dish_name, :name) > 0.2
            ORDER BY GREATEST(SIMILARITY(F.dish_name, :name)) DESC
            LIMIT 10
        """, nativeQuery = true)
    List<Dish> findAllDishesByNameSimilarity(@Param("name") String name);
}
