package lk.easycar.rental.repo;

import lk.easycar.rental.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepo extends JpaRepository<UserLogin, String> {
    boolean existsByEmail(String email);
}
