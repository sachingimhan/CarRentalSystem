package lk.easycar.rental.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import lk.easycar.rental.dto.CustomerDTO;
import lk.easycar.rental.service.CustomerService;
import lk.easycar.rental.util.StrandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
        boolean b = service.saveCustomer(dto);
        if (b) {
            return new ResponseEntity(new StrandedResponse(b, "Customer Saved.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(b, "Customer Not Saved.!"), HttpStatus.OK);
        }

    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        boolean b = service.updateCustomer(dto);
        if (b) {
            return new ResponseEntity(new StrandedResponse(b, "Customer Updated.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(b, "Customer Not Updated.!"), HttpStatus.OK);
        }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam("id") String id) {
        boolean b = service.deleteCustomer(id);
        if (b) {
            return new ResponseEntity(new StrandedResponse(b, "Customer Deleted.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(b, "Customer Not Deleted.!"), HttpStatus.OK);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable("id") String id) {
        CustomerDTO customerDTO = service.searchCustomer(id);
        if (customerDTO != null) {
            return new ResponseEntity(new StrandedResponse(true, "Customer Found.!", customerDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(false, "Customer Not Found.!"), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        List<CustomerDTO> allCustomers = service.getAllCustomers();
        if (allCustomers != null) {
            return new ResponseEntity(new StrandedResponse(true, "Customers Found.!", allCustomers), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(false, "Customers Not Found.!"), HttpStatus.OK);
        }
    }

}
