package lk.easycar.rental.service.impl;

import lk.easycar.rental.dto.UserLoginDTO;
import lk.easycar.rental.entity.Customer;
import lk.easycar.rental.entity.UserLogin;
import lk.easycar.rental.repo.CustomerRepo;
import lk.easycar.rental.repo.UserLoginRepo;
import lk.easycar.rental.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserLoginRepo repo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public boolean registration(UserLoginDTO dto) {
        if (!repo.existsByEmail(dto.getEmail())) {
            dto.setRole("User");
            repo.save(mapper.map(dto, UserLogin.class));
            customerRepo.save(mapper.map(dto.getCustomer(), Customer.class));
            return true;
        }
        return false;
    }

    @Override
    public UserLoginDTO userLogin(String email, String password) {
        if (repo.existsByEmail(email)) {
            UserLogin user = repo.checkLogin(email, password);
            if (user != null) {
                return mapper.map(user, UserLoginDTO.class);
            } else {
                throw new RuntimeException("Incorrect Password");
            }
        } else {
            throw new RuntimeException("Incorrect Email or Password");
        }
    }

    @Override
    public boolean updateUserDetails(UserLoginDTO dto) {
        if (repo.existsByEmail(dto.getEmail())) {
            repo.save(mapper.map(dto, UserLogin.class));
            return true;
        }
        return false;
    }
}
