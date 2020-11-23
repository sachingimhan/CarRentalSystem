package lk.easycar.rental.service;

import lk.easycar.rental.dto.CarDTO;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.util.List;

public interface CarService {
    boolean saveCar(CarDTO dto);

    boolean updateCar(CarDTO dto);

    CarDTO searchCar(String id);

    boolean deleteCar(String id);

    List<CarDTO> getAllCars();

    Page<CarDTO> getAllCars(int page, int size);

    List<CarDTO> getCars(Date from, Date to, String type);
}
