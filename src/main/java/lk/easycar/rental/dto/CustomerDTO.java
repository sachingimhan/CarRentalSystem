package lk.easycar.rental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {

    private String nic;
    private String name;
    private String address;
    private String contact;
    private String drivingLicNo;

    public CustomerDTO(String nic, String name, String address, String contact, String drivingLicNo) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.drivingLicNo = drivingLicNo;
    }

}
