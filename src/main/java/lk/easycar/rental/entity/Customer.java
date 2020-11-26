package lk.easycar.rental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    @Id
    private String nic;
    private String name;
    private String address;
    private String contact;
    private String drivingLicNo;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rent> rentList;


    public Customer(String nic, String name, String address, String contact, String drivingLicNo) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.drivingLicNo = drivingLicNo;
    }
}
