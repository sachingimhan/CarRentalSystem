package lk.easycar.rental.repo;

import lk.easycar.rental.dto.RentDTO;
import lk.easycar.rental.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepo extends JpaRepository<Rent, Integer> {

}
