package lk.easycar.rental.service;

import lk.easycar.rental.dto.RentDTO;

import java.util.List;

public interface RentService {
    boolean saveRent(RentDTO dto);

    boolean updateRent(RentDTO dto);

    List<RentDTO> searchRent(String id);

    boolean deleteRent(int id);

    List<RentDTO> getAllRents();

    boolean requestStateChange(String reqId, String state,String reason);
}
