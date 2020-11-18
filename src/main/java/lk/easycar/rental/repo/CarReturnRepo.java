package lk.easycar.rental.repo;

import lk.easycar.rental.entity.CarReturn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarReturnRepo extends JpaRepository<lk.easycar.rental.entity.CarReturn, Integer> {
}
