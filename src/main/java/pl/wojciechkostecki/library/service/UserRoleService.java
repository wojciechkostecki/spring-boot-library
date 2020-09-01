package pl.wojciechkostecki.library.service;

import org.springframework.stereotype.Service;
import pl.wojciechkostecki.library.model.UserRole;
import pl.wojciechkostecki.library.repository.UserRoleRepository;

@Service
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }
}
