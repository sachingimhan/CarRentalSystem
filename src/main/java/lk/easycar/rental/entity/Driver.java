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
public class Driver {
    @Id
    private String nic;
    private String fullName;
    private String address;
    private String contact;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rent> rentList;

    public Driver(String nic, String fullName, String address, String contact) {
        this.nic = nic;
        this.fullName = fullName;
        this.address = address;
        this.contact = contact;
    }
}
