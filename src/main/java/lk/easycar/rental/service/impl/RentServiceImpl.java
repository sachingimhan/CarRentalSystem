package lk.easycar.rental.service.impl;

import lk.easycar.rental.dto.CarDTO;
import lk.easycar.rental.dto.CustomerDTO;
import lk.easycar.rental.dto.DriverDTO;
import lk.easycar.rental.dto.RentDTO;
import lk.easycar.rental.entity.Rent;
import lk.easycar.rental.repo.CarRepo;
import lk.easycar.rental.repo.CustomerRepo;
import lk.easycar.rental.repo.DriverRepo;
import lk.easycar.rental.repo.RentRepo;
import lk.easycar.rental.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        if (!repo.existsById(dto.getReqId())) {
            Rent map = mapper.map(dto, Rent.class);
            repo.save(map);
            return true;
        }
        return false;
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
