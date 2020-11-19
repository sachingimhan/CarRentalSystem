package lk.easycar.rental.entity;

import lombok.*;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    @Id
    private String regNo;
    private String brand;
    private String type;
    private int passengerCount;
    private String color;
    private String transmissionType;
    private String fuelType;
    private double dailyRate;
    private double monthlyRate;
    private double extraKmPrice;
    private double dailyFreeKm;
    private double monthlyFreeKm;
    private double drivenKm;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private List<Rent> rentList = new ArrayList<>();

    public Car(String regNo, String brand, String type, int passengerCount, String color, String transmissionType, String fuelType, double dailyRate, double monthlyRate, double extraKmPrice, double dailyFreeKm, double monthlyFreeKm, double drivenKm) {
        this.regNo = regNo;
        this.brand = brand;
        this.type = type;
        this.passengerCount = passengerCount;
        this.color = color;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
        this.dailyRate = dailyRate;
        this.monthlyRate = monthlyRate;
        this.extraKmPrice = extraKmPrice;
        this.dailyFreeKm = dailyFreeKm;
        this.monthlyFreeKm = monthlyFreeKm;
        this.drivenKm = drivenKm;
    }
}
