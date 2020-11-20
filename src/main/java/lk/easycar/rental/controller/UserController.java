package lk.easycar.rental.controller;

import lk.easycar.rental.dto.UserLoginDTO;
import lk.easycar.rental.service.FilesStorageService;
import lk.easycar.rental.service.UserService;
import lk.easycar.rental.util.StrandedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity uploadFiles(@RequestParam(value = "file[]") MultipartFile[] files, @RequestParam("nic") String id, HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        for (MultipartFile file : files) {
            storageService.save(file, id, rootPath);
        }
        return new ResponseEntity(new StrandedResponse(true, "Success.!"), HttpStatus.OK);
    }

    @GetMapping(path = "/load")
    public ResponseEntity loadFiles(HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        String s = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        System.out.println(s);
        storageService.load("153698572V", rootPath);

        return new ResponseEntity(new StrandedResponse(true, "Success.!"), HttpStatus.OK);
    }

}
