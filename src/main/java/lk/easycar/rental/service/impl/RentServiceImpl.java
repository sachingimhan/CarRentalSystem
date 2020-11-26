package lk.easycar.rental.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lk.easycar.rental.dto.RentDTO;
import lk.easycar.rental.entity.Car;
import lk.easycar.rental.entity.Customer;
import lk.easycar.rental.entity.Rent;
import lk.easycar.rental.repo.CarRepo;
import lk.easycar.rental.repo.CustomerRepo;
import lk.easycar.rental.repo.DriverRepo;
import lk.easycar.rental.repo.RentRepo;
import lk.easycar.rental.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentServiceImpl implements RentService {
    @Autowired
    RentRepo repo;
    @Autowired
    ModelMapper mapper;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CarRepo carRepo;
    @Autowired
    DriverRepo driverRepo;

    @Override
    public boolean saveRent(RentDTO dto) {
        Rent map = mapper.map(dto, Rent.class);
        Rent save = repo.save(map);
        return save != null;
    }

    @Override
    public boolean updateRent(RentDTO dto) {
        if (repo.existsById(dto.getReqId())) {
            repo.save(mapper.map(dto, Rent.class));
            return true;
        }
        return false;
    }

    @Override
    public RentDTO searchRent(int id) {
        return mapper.map(repo.findById(id), RentDTO.class);
    }

    @Override
    public boolean deleteRent(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<RentDTO> getAllRents() {
        List<Rent> all = repo.findAll();
        if (all.size() > 0) {
            return mapper.map(all, new TypeToken<List<RentDTO>>() {
            }.getType());
        }
        return null;
    }
}
