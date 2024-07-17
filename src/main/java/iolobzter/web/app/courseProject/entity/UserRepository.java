package iolobzter.web.app.courseProject.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {



    Optional<User> findByUsername(String username);
}
