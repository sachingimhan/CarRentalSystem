package lk.easycar.rental.repo;

import lk.easycar.rental.entity.Car;
import lk.easycar.rental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface DriverRepo extends JpaRepository<Driver, String> {
    @Query(value = "SELECT * FROM driver WHERE nic NOT IN (SELECT DrId FROM rent WHERE (:pikupDate BETWEEN fromDate AND toDate AND :returnDate BETWEEN fromDate AND toDate))", nativeQuery = true)
    List<Driver> searchAvailableDrivers(@Param("pikupDate") Date pikupDate, @Param("returnDate") Date returnDate);
}
