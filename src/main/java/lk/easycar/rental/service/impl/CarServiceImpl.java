package lk.easycar.rental.service.impl;

import lk.easycar.rental.dto.CarDTO;
import lk.easycar.rental.entity.Car;
import lk.easycar.rental.repo.CarRepo;
import lk.easycar.rental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private CarRepo repo;

    private ModelMapper mapper;

    @Autowired
    public CarServiceImpl(CarRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public boolean saveCar(CarDTO dto) {
        if (!repo.existsById(dto.getRegNo())) {
            repo.save(mapper.map(dto, Car.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCar(CarDTO dto) {
        if (repo.existsById(dto.getRegNo())) {
            repo.save(mapper.map(dto, Car.class));
            return true;
        }
        return false;
    }

    @Override
    public CarDTO searchCar(String id) {
        if (id != null) {
            Optional<Car> car = repo.findById(id);
            if (car.isPresent()) {
                return mapper.map(car.get(), CarDTO.class);
            }
        }
        return null;
    }

    @Override
    public boolean deleteCar(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> all = repo.findAll();
        if (all.size() > 0) {
            return mapper.map(all, new TypeToken<List<CarDTO>>() {
            }.getType());
        }
        return null;
    }
}
