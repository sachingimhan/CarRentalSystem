package lk.easycar.rental.dto;

import lk.easycar.rental.entity.Driver;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class RentDTO {

    private int reqId;
    private Date date;
    private Date fromDate;
    private Date toDate;
    private String pickUpNote;
    private String returnNote;
    private BigDecimal waiverAmount;
    private String state;
    private CustomerDTO customer;
    private CarDTO car;
    private CarReturnDTO returnCar;
    private Driver driver;

    public RentDTO(int reqId, Date date, Date fromDate, Date toDate, String pickUpNote, String returnNote, BigDecimal waiverAmount, String state, CustomerDTO customer, CarDTO car) {
        this.reqId = reqId;
        this.date = date;
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
