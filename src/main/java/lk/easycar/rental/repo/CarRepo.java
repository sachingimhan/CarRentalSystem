package lk.easycar.rental.repo;

import lk.easycar.rental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface CarRepo extends JpaRepository<Car, String> {
    @Query(value = "SELECT * FROM car WHERE regNo NOT IN (SELECT RegNo FROM rent WHERE (:pikupDate BETWEEN fromDate AND toDate AND :returnDate BETWEEN fromDate AND toDate)) AND type=:cType", nativeQuery = true)
    List<Car> searchCar(@Param("pikupDate") Date pikupDate, @Param("returnDate") Date returnDate, @Param("cType") String cType);
}
