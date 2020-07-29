package pl.wojciechkostecki.library.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojciechkostecki.library.model.User;
import pl.wojciechkostecki.library.service.UserService;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user){
        logger.debug("REST request to create User: {}", user.getUsername());
        userService.registerUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
