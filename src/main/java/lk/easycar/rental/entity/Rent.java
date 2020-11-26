package lk.easycar.rental.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reqId;
    private Date palaceDate;
    private Date fromDate;
    private Date toDate;
    private String pickUpNote;
    private String returnNote;
    private BigDecimal waiverAmount;
    private String state;
    @Nullable
    @JsonIgnore
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustNic", referencedColumnName = "nic", nullable = false)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RegNo", referencedColumnName = "regNo", nullable = false)
    @JsonIgnore
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DrId", referencedColumnName = "nic", nullable = true)
    @JsonIgnore
    private Driver driver;

    @OneToOne(mappedBy = "rent", cascade = CascadeType.ALL)
    @JsonIgnore
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
