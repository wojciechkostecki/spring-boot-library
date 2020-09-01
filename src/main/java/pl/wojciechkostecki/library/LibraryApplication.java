package pl.wojciechkostecki.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.wojciechkostecki.library.model.Role;
import pl.wojciechkostecki.library.model.User;
import pl.wojciechkostecki.library.model.UserRole;
import pl.wojciechkostecki.library.repository.UserRepository;
import pl.wojciechkostecki.library.service.UserRoleService;
import pl.wojciechkostecki.library.service.UserService;

@SpringBootApplication
public class LibraryApplication {

    private final UserRoleService userRoleService;

    private final UserService userService;

    private final UserRepository userRepository;

    public LibraryApplication(UserRepository userRepository, UserRoleService userRoleService, UserService userService) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void afterInitSetup() {
        saveRoles();
        saveUsers();
    }

    private void saveUsers() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.registerUser(user);
    }

    private void saveRoles() {
        for (Role role : Role.values()) {
            UserRole userRole = new UserRole();
            userRole.setName(role);
            userRoleService.save(userRole);
        }
    }
}