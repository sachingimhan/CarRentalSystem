package lk.easycar.rental.repo;

import lk.easycar.rental.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentRepo extends JpaRepository<Rent, Integer> {
    @Query(value = "SELECT * FROM rent WHERE CustNic=:nic", nativeQuery = true)
    List<Rent> getAllRequestFromCustomer(@Param("nic") String nic);

    @Query(value = "UPDATE rent SET state=:val2, reason=:val3 WHERE reqId=:val1 ", nativeQuery = true)
    void changeRequestState(@Param("val1") String req, @Param("val2") String state, @Param("val3") String reason);
}
