package dietmaker.user.application.contracts.requests;

import java.util.Date;

import dietmaker.user.domain.enums.Gender;

public record UserRequestDTO(
        String userName,
        String email,
        String password,
        Date birthDate,
        Gender gender,
        Double height,
        Double weight,
        Double activityLevelCoefficient) {
}
