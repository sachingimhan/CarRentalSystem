package lk.easycar.rental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payId;
    private Date date;
    private BigDecimal totalAmount;
    @OneToOne
    @JoinColumn(name = "rentId",referencedColumnName = "rid",nullable = false)
    private CarReturn returnCar;
    @OneToMany(mappedBy = "payment")
    private List<PaymentDetail> details;

    public Payment(int payId, Date date, BigDecimal totalAmount, CarReturn returnCar, List<PaymentDetail> details) {
        this.payId = payId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.returnCar = returnCar;
        this.details = details;
    }
}
