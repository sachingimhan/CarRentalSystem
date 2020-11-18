package lk.easycar.rental.service;

import lk.easycar.rental.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    boolean saveCustomer(CustomerDTO dto);

    boolean updateCustomer(CustomerDTO dto);

    CustomerDTO searchCustomer(String id);

    boolean deleteCustomer(String id);

    List<CustomerDTO> getAllCustomers();
}
