package lk.easycar.rental.service;

import lk.easycar.rental.dto.UserLoginDTO;

public interface UserService {
    boolean registration(UserLoginDTO dto);

    UserLoginDTO userLogin(String email,String password);

    boolean updateUserDetails(UserLoginDTO dto);
}
