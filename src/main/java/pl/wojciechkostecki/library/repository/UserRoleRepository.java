package pl.wojciechkostecki.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojciechkostecki.library.model.Role;
import pl.wojciechkostecki.library.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    UserRole findByName(Role name);
}
