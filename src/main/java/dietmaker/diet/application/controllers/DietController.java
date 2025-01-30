package dietmaker.diet.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dietmaker.diet.application.contracts.requests.DietRequestDTO;
import dietmaker.diet.application.contracts.responses.DietDTO;
import dietmaker.diet.application.services.DietService;

@RestController
@RequestMapping("diets")
public class DietController {

    @Autowired
    private DietService dietService;

    @PostMapping
    public ResponseEntity<Void> createDiet(@RequestBody DietRequestDTO dietRequestDTO) {
        dietService.createDiet(dietRequestDTO);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<DietDTO>> listDietsByUserId(@RequestParam UUID userId) {
        List<DietDTO> diets = dietService.listDietsByUserId(userId);

        return ResponseEntity.ok(diets);
    }
}
