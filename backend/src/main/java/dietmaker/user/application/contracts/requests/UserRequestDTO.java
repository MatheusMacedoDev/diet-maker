package dietmaker.user.application.contracts.requests;

import java.util.Date;

import dietmaker.user.domain.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record UserRequestDTO(
        @NotBlank(message = "Name is mandatory") String userName,

        @NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email,

        @NotBlank(message = "Password is mandatory") @Min(value = 8, message = "Password should have at least 8 characters") String password,

        @NotNull(message = "Birth date is mandatory") @Past(message = "Birth date should not be in the future") Date birthDate,

        @NotNull(message = "Gender is mandatory") Gender gender,

        @NotNull(message = "Height is mandatory") Double height,

        @NotNull(message = "Weight is mandatory") Double weight,

        @NotNull(message = "Activity level coefficient is mandatory") Double activityLevelCoefficient) {
}
