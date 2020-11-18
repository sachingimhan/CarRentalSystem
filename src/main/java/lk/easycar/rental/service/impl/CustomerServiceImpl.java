package lk.easycar.rental.service.impl;

import lk.easycar.rental.dto.CustomerDTO;
import lk.easycar.rental.entity.Customer;
<<<<<<< HEAD
import lk.easycar.rental.repo.CustomerRepo;
import lk.easycar.rental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
=======
import lk.easycar.rental.entity.UserLogin;
import lk.easycar.rental.repo.CustomerRepo;
import lk.easycar.rental.repo.UserLoginRepo;
import lk.easycar.rental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
>>>>>>> 73bbd27... SiginUp
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

<<<<<<< HEAD
    @Autowired
    CustomerRepo repo;
    @Autowired
    ModelMapper mapper;
=======
    private UserLoginRepo loginRepo;

    private CustomerRepo repo;

    private ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepo repo, ModelMapper mapper, UserLoginRepo loginRepo) {
        this.repo = repo;
        this.mapper = mapper;
        this.loginRepo = loginRepo;
    }
>>>>>>> 73bbd27... SiginUp

    @Override
    public boolean saveCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getNic())) {
            repo.save(mapper.map(dto, Customer.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getNic())) {
            repo.save(mapper.map(dto, Customer.class));
            return true;
        }
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (id != null) {
            Optional<Customer> customer = repo.findById(id);
            if (customer.isPresent()) {
                return mapper.map(customer.get(), CustomerDTO.class);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(String id) {
        if (id != null) {
            if (repo.existsById(id)) {
                repo.deleteById(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        if (all.size() != 0) {
            return mapper.map(all, new TypeToken<List<CustomerDTO>>() {
            }.getType());
        }
        return null;
    }
}
