package lk.easycar.rental.service;

import lk.easycar.rental.dto.DriverDTO;

import java.sql.Date;
import java.util.List;

public interface DriverService {
    boolean saveDriver(DriverDTO dto);

    boolean updateDriver(DriverDTO dto);

    DriverDTO searchDriver(String id);

    boolean deleteDriver(String id);

    List<DriverDTO> getAllDrivers();

    List<DriverDTO> searchAvailableDrivers(Date from, Date to);
}
