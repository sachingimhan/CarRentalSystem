package lk.easycar.rental.entity;

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
public class Driver {
    @Id
    private String nic;
    private String fullName;
    private String address;
    private String contact;
    @OneToMany(mappedBy = "driver")
    private List<Rent> rentList;

    public Driver(String nic, String fullName, String address, String contact) {
        this.nic = nic;
        this.fullName = fullName;
        this.address = address;
        this.contact = contact;
    }
}
