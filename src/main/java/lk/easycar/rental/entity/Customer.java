package lk.easycar.rental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private List<Rent> rentList;


    public Customer(String nic, String name, String address, String contact, String drivingLicNo) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.drivingLicNo = drivingLicNo;
    }
}
