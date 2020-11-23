package lk.easycar.rental.repo;

import lk.easycar.rental.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.nio.file.OpenOption;

public interface UserLoginRepo extends JpaRepository<UserLogin, String> {
    boolean existsByEmail(String email);

    UserLogin findByEmail(String email);

    @Query(value = "SELECT * FROM userlogin WHERE email=:email AND password=:pass", nativeQuery = true)
    UserLogin checkLogin(@Param("email") String email, @Param("pass") String password);
}
