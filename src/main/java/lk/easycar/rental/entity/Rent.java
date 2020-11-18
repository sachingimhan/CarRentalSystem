package lk.easycar.rental.entity;

<<<<<<< HEAD
import lombok.*;
=======
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
>>>>>>> 73bbd27... SiginUp

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@NoArgsConstructor
<<<<<<< HEAD
@AllArgsConstructor
=======
>>>>>>> 73bbd27... SiginUp
@Getter
@Setter
@ToString
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reqId;
    private Date date;
    private Time time;
    private String pickUpNote;
    private String returnNote;
    private BigDecimal waiverAmount;
    private String state;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "CustNic", referencedColumnName = "nic", nullable = false)
    private Customer customer;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "RegNo", referencedColumnName = "regNo", nullable = false)
    private Car car;
<<<<<<< HEAD

=======
    @OneToOne(mappedBy = "rent")
    private CarReturn returnCar;
    @ManyToOne
    @JoinColumn(name = "DrId", referencedColumnName = "nic", nullable = false)
    private Driver driver;

    public Rent(int reqId, Date date, Time time, String pickUpNote, String returnNote, BigDecimal waiverAmount, String state, Customer customer, Car car, Driver driver) {
        this.reqId = reqId;
        this.date = date;
        this.time = time;
        this.pickUpNote = pickUpNote;
        this.returnNote = returnNote;
        this.waiverAmount = waiverAmount;
        this.state = state;
        this.customer = customer;
        this.car = car;
        this.driver = driver;
    }
>>>>>>> 73bbd27... SiginUp
}
