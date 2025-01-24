package dietmaker.diet.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dietmaker.diet.application.contracts.requests.FoodRequestDTO;
import dietmaker.diet.application.services.FoodService;

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
}
