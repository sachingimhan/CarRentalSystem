package lk.easycar.rental.controller;

import lk.easycar.rental.dto.CarDTO;
import lk.easycar.rental.service.CarService;
import lk.easycar.rental.util.StrandedResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@CrossOrigin
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCar(@RequestBody CarDTO dto) {
        boolean b = carService.saveCar(dto);
        if (b) {
            return new ResponseEntity(new StrandedResponse(b, "Car Saved.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(b, "Car Not Saved.!"), HttpStatus.OK);
        }

    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCar(@RequestBody CarDTO dto) {
        boolean b = carService.updateCar(dto);
        if (b) {
            return new ResponseEntity(new StrandedResponse(b, "Car Updated.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(b, "Car Not Updated.!"), HttpStatus.OK);
        }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCar(@RequestParam("id") String id) {
        boolean b = carService.deleteCar(id);
        if (b) {
            return new ResponseEntity(new StrandedResponse(b, "Car Deleted.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(b, "Car Not Deleted.!"), HttpStatus.OK);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCar(@PathVariable("id") String id) {
        CarDTO carDTO = carService.searchCar(id);
        if (carDTO != null) {
            return new ResponseEntity(new StrandedResponse(true, "Car Found.!", carDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(false, "Car Not Found.!"), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity getAllCars() {
        List<CarDTO> allCars = carService.getAllCars();
        if (allCars.size() > 0) {
            return new ResponseEntity(new StrandedResponse(true, "Car Found.!", allCars), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(false, "Car Not Found.!"), HttpStatus.OK);
        }
    }

    @GetMapping(params = {"page", "size"})
    public ResponseEntity getAllCars(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "5") int size, Model model) {
        Page<CarDTO> allCars = carService.getAllCars(page, size);
        model.addAttribute("pageCount", allCars.getTotalPages());
        model.addAttribute("rowCount", allCars.getTotalElements());
        model.addAttribute("data", allCars.getContent());
        if (!allCars.isEmpty()) {
            return new ResponseEntity(new StrandedResponse(true, "Cars Found.!", model), HttpStatus.OK);
        } else {
            return new ResponseEntity(new StrandedResponse(false, "Car Not Found.!"), HttpStatus.OK);
        }
    }

    @GetMapping(path = "find", params = {"fromDate", "toDate", "type"})
    public ResponseEntity findCar(@RequestParam("fromDate") Date fromDate, @RequestParam("toDate") Date toDate, @RequestParam("type") String type) {
        List<CarDTO> cars = carService.getCars(fromDate, toDate, type);
        if (cars.size() > 0) {
            return new ResponseEntity(new StrandedResponse(true, "Found", cars), HttpStatus.OK);
        }
        return new ResponseEntity(new StrandedResponse(false, "Not Found"), HttpStatus.OK);
    }

}
