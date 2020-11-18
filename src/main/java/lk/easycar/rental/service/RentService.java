package lk.easycar.rental.service;

import lk.easycar.rental.dto.CarDTO;
import lk.easycar.rental.dto.RentDTO;

import java.util.List;

public interface RentService {
    boolean saveRent(RentDTO dto);

    boolean updateRent(RentDTO dto);

    RentDTO searchRent(int id);

    boolean deleteRent(int id);

    List<RentDTO> getAllRents();
}
