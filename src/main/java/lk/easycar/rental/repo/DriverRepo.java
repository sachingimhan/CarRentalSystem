package lk.easycar.rental.repo;

import lk.easycar.rental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, String> {
}
