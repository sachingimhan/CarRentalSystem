package lk.easycar.rental.dto;

import lk.easycar.rental.entity.Rent;
import lk.easycar.rental.entity.UserLogin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class DriverDTO {

    private String nic;
    private String fullName;
    private String address;
    private String contact;

    public DriverDTO(String nic, String fullName, String address, String contact) {
        this.nic = nic;
        this.fullName = fullName;
        this.address = address;
        this.contact = contact;
    }
}
