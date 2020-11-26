package lk.easycar.rental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lk.easycar.rental.dto.RentDTO;
import lk.easycar.rental.service.RentService;
import lk.easycar.rental.util.StrandedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rent")
@CrossOrigin
public class RentController {


    private RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCar(@RequestBody RentDTO dto) {
        boolean b = rentService.saveRent(dto);
        if (b) {
            return new ResponseEntity(new StrandedResponse(b, "Rent Saved.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(b, "Rent Not Saved.!"), HttpStatus.OK);
        }

    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCar(@RequestBody RentDTO dto) {
        boolean b = rentService.updateRent(dto);
        if (b) {
            return new ResponseEntity(new StrandedResponse(b, "Rent Updated.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(b, "Rent Not Updated.!"), HttpStatus.OK);
        }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCar(@RequestParam("id") int id) {
        boolean b = rentService.deleteRent(id);
        if (b) {
            return new ResponseEntity(new StrandedResponse(b, "Rent Deleted.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(b, "Rent Not Deleted.!"), HttpStatus.OK);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCar(@PathVariable("id") int id) {
        RentDTO rentDTO = rentService.searchRent(id);
        if (rentDTO != null) {
            return new ResponseEntity(new StrandedResponse(true, "Rent Found.!", rentDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(false, "Rent Not Found.!"), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity getAllCars() {
        List<RentDTO> allRents = rentService.getAllRents();
        if (allRents != null) {
            return new ResponseEntity(new StrandedResponse(true, "Rents Found.!", allRents), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(false, "Rents Not Found.!"), HttpStatus.OK);
        }
    }

}
