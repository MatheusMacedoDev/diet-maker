package dietmaker.diet.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dietmaker.diet.application.contracts.requests.MealRequestDTO;
import dietmaker.diet.application.services.MealService;

@RestController
@RequestMapping("meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @PostMapping
    public ResponseEntity<Void> createMeal(@RequestBody MealRequestDTO mealRequestDTO) {
        mealService.createMeal(mealRequestDTO);

        return ResponseEntity.status(201).build();
    }

    // @GetMapping("/{dietId}")
    // public ResponseEntity<FullDietDTO> getDietById(@RequestParam UUID dietId) {
    // FullDietDTO diet = dietService.getDietById(dietId);
    //
    // return ResponseEntity.ok(diet);
    // }

    // @GetMapping("users/{userId}")
    // public ResponseEntity<List<DietDTO>> listDietsByUserId(@RequestParam UUID
    // userId) {
    // List<DietDTO> diets = dietService.listDietsByUserId(userId);
    //
    // return ResponseEntity.ok(diets);
    // }
}
