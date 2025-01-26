package dietmaker.diet.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dietmaker.diet.application.contracts.requests.FoodRequestDTO;
import dietmaker.diet.application.services.FoodService;
import dietmaker.diet.domain.entities.Food;

@RestController
@RequestMapping("foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping
    public ResponseEntity<Void> createFood(@RequestBody FoodRequestDTO foodRequestDTO) {
        foodService.createFood(foodRequestDTO);

        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Food>> findFoodsByName(@RequestParam String name) {
        List<Food> foods = foodService.findFoodsByName(name);

        return ResponseEntity.ok(foods);
    }
}
