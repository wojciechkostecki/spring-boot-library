package pl.wojciechkostecki.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.wojciechkostecki.library.model.Role;
import pl.wojciechkostecki.library.model.UserRole;
import pl.wojciechkostecki.library.repository.UserRepository;
import pl.wojciechkostecki.library.service.UserRoleService;

@SpringBootApplication
public class LibraryApplication {

    private final UserRoleService userRoleService;

    private final UserRepository userRepository;

    public LibraryApplication(UserRepository userRepository, UserRoleService userRoleService) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void afterInitSetup() {
        saveRoles();
    }

    private void saveRoles() {
        for (Role role : Role.values()) {
            UserRole userRole = new UserRole();
            userRole.setName(role);
            userRoleService.save(userRole);
        }
    }
}