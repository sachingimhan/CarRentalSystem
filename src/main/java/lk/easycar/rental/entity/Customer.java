package lk.easycar.rental.entity;

<<<<<<< HEAD
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
=======
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
>>>>>>> 73bbd27... SiginUp
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
<<<<<<< HEAD
    @OneToMany(mappedBy = "customer")
    private List<Rent> rentList = new ArrayList<>();
=======
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Rent> rentList;
>>>>>>> 73bbd27... SiginUp

    public Customer(String nic, String name, String address, String contact, String drivingLicNo) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.drivingLicNo = drivingLicNo;
    }
<<<<<<< HEAD
=======

>>>>>>> 73bbd27... SiginUp
}
