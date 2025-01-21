package dietmaker.user.application.contracts.requests;

public record UserRequestDTO(
        String userName,
        String email,
        String password,
        Double weight,
        Double activityLevelCoefficient) {
}
