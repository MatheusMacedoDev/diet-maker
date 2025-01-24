package dietmaker.diet.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dietmaker.diet.application.contracts.requests.FoodRequestDTO;
import dietmaker.diet.domain.entities.Food;
import dietmaker.diet.domain.repositories.FoodRepository;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public void createFood(FoodRequestDTO request) {
        Food food = new Food(request);
        foodRepository.save(food);
    }
}
