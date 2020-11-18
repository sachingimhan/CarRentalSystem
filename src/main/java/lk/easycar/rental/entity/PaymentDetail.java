package lk.easycar.rental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaymentDetail {
    @Id
    private int payId;
    private String description;
    private BigDecimal amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentId", referencedColumnName = "payId", nullable = false)
    private Payment payment;

    public PaymentDetail(int payId, String description, BigDecimal amount) {
        this.payId = payId;
        this.description = description;
        this.amount = amount;
    }
}
