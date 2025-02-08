package dietmaker.diet.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dietmaker.diet.domain.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Short> {
    @Query(value = """
        SELECT * from foods AS F
        WHERE SIMILARITY(F.food_name, :name) > 0.2
        ORDER BY GREATEST(SIMILARITY(F.food_name, :name)) DESC
        LIMIT 10
    """, nativeQuery = true)
    List<Food> findAllFoodsByNameSimilarity(@Param("name") String name);
}
