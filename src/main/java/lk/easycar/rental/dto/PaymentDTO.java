package lk.easycar.rental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaymentDTO {

    private int payId;
    private Date date;
    private BigDecimal totalAmount;
    private CarReturnDTO returnCar;
    private List<PaymentDetail> details;

    public PaymentDTO(int payId, Date date, BigDecimal totalAmount, CarReturnDTO returnCar, List<PaymentDetail> details) {
        this.payId = payId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.returnCar = returnCar;
        this.details = details;
    }
}
