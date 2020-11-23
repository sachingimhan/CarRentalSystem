package lk.easycar.rental.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reqId;
    private Date palaceDate;
    private Date fromDate;
    private Date toDate;
    private String pickUpNote;
    private String returnNote;
    private BigDecimal waiverAmount;
    private String state;
    @ManyToOne
    @JoinColumn(name = "CustNic", referencedColumnName = "nic", nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "RegNo", referencedColumnName = "regNo", nullable = false)
    private Car car;
    @ManyToOne
    @JoinColumn(name = "DrId", referencedColumnName = "nic", nullable = true)
    private Driver driver;
    @OneToOne(mappedBy = "rent")
    private CarReturn returnCar;


    public Rent(int reqId, Date palaceDate, Date fromDate, Date toDate, String pickUpNote, String returnNote, BigDecimal waiverAmount, String state, Customer customer, Car car) {
        this.reqId = reqId;
        this.palaceDate = palaceDate;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.pickUpNote = pickUpNote;
        this.returnNote = returnNote;
        this.waiverAmount = waiverAmount;
        this.state = state;
        this.customer = customer;
        this.car = car;
    }
}
