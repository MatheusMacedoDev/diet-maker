package dietmaker.user.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dietmaker.user.application.contracts.requests.LoginRequestDTO;
import dietmaker.user.application.contracts.requests.UserRequestDTO;
import dietmaker.user.application.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);

        return ResponseEntity.status(201).build();
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        String token = userService.login(loginRequestDTO);

        return ResponseEntity.ok(token);
    }
}
