package lk.easycar.rental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Driver;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserLoginDTO {

    private String id;
    private String email;
    private String password;
    private String role;
    private CustomerDTO customer;

    private Driver driver;

    public UserLoginDTO(String id, String email, String password, String role, CustomerDTO customer) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.customer = customer;
    }

}
