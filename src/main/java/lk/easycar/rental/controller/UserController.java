package lk.easycar.rental.controller;

import lk.easycar.rental.dto.UserLoginDTO;
import lk.easycar.rental.service.UserService;
import lk.easycar.rental.util.StrandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserLoginDTO dto) {
        boolean registration = service.registration(dto);
        if (registration) {
            return new ResponseEntity(new StrandedResponse(true, "Success.!"), HttpStatus.OK);
        }
        return new ResponseEntity(new StrandedResponse(false, "Fail.!"), HttpStatus.OK);
    }

}
