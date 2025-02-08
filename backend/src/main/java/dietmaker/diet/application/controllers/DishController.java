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

import dietmaker.diet.application.contracts.requests.DishRequestDTO;
import dietmaker.diet.application.contracts.responses.DishDTO;
import dietmaker.diet.application.services.DishService;

@RestController
@RequestMapping("dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    public ResponseEntity<Void> createDish(@RequestBody DishRequestDTO dishRequestDTO) {
        dishService.createDish(dishRequestDTO);

        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<DishDTO>> findDishesByName(@RequestParam String name) {
        List<DishDTO> dishes = dishService.findDishesByName(name);

        return ResponseEntity.ok(dishes);
    }
}
