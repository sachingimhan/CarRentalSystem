package lk.easycar.rental.service;

import lk.easycar.rental.dto.CarDTO;
import lk.easycar.rental.dto.CustomerDTO;

import java.util.List;

public interface CarService {
    boolean saveCar(CarDTO dto);

    boolean updateCar(CarDTO dto);

    CarDTO searchCar(String id);

    boolean deleteCar(String id);

    List<CarDTO> getAllCars();
}
