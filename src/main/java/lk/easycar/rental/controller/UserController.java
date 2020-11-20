package lk.easycar.rental.controller;

import lk.easycar.rental.dto.UserLoginDTO;
import lk.easycar.rental.service.FilesStorageService;
import lk.easycar.rental.service.UserService;
import lk.easycar.rental.util.StrandedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {


    private UserService service;
    private FilesStorageService storageService;

    public UserController(UserService service, FilesStorageService storageService) {
        this.service = service;
        this.storageService = storageService;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserLoginDTO dto) {
        boolean registration = service.registration(dto);
        if (registration) {
            return new ResponseEntity(new StrandedResponse(true, "Success.!"), HttpStatus.OK);
        }
        return new ResponseEntity(new StrandedResponse(false, "Fail.!"), HttpStatus.OK);
    }

    @PostMapping(path = "/upload")
    public ResponseEntity uploadFiles(@RequestParam(value = "file[]") MultipartFile[] files) {
        for (MultipartFile file : files) {
            storageService.save(file);
        }
        return new ResponseEntity(new StrandedResponse(true, "Success.!"), HttpStatus.OK);
    }

}
