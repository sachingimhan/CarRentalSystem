package lk.easycar.rental.repo;

import lk.easycar.rental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {

}
