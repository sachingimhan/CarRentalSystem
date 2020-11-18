package lk.easycar.rental.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CarReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int rid;
    private Date date;
    private BigDecimal drivenKm;
    @OneToOne
    @JoinColumn(name = "requestId", referencedColumnName = "reqId", nullable = false)
    private Rent rent;
    @OneToOne(mappedBy = "returnCar")
    private Payment payment;

    public CarReturn(int rid, Date date, BigDecimal drivenKm, Rent rent) {
        this.rid = rid;
        this.date = date;
        this.drivenKm = drivenKm;
        this.rent = rent;
    }
}
