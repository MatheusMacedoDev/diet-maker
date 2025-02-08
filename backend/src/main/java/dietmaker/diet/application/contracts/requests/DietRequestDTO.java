package dietmaker.diet.application.contracts.requests;

import java.util.UUID;

public record DietRequestDTO(String dietName, short dietWaterMl, UUID userId) {
}
