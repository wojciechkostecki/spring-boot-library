package pl.wojciechkostecki.library.service;

import antlr.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wojciechkostecki.library.model.User;
import pl.wojciechkostecki.library.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private User save(User user) {
        return userRepository.save(user);
    }

    public User registerUser(User user) {
        if (!Strings.isNotBlank(user.getPassword()) || !Strings.isNotBlank(user.getUsername())) {
            throw new RuntimeException("Username and password cannot be null or empty");
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("There is a user with given username");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return save(user);
    }
}
