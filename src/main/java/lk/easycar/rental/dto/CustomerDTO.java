package lk.easycar.rental.dto;

<<<<<<< HEAD
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
=======
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
>>>>>>> 73bbd27... SiginUp
@Getter
@Setter
@ToString
public class CustomerDTO {
<<<<<<< HEAD
=======

>>>>>>> 73bbd27... SiginUp
    private String nic;
    private String name;
    private String address;
    private String contact;
    private String drivingLicNo;
<<<<<<< HEAD
=======

    public CustomerDTO(String nic, String name, String address, String contact, String drivingLicNo) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.drivingLicNo = drivingLicNo;
    }

>>>>>>> 73bbd27... SiginUp
}
