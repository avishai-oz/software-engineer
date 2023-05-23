package com.example;

import javax.persistence.*;

@Entity
@Table(name = "JunctionTable_Car_Garage")
public class JunctionTable_Car_Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int garageId;
    private int carId;

    public JunctionTable_Car_Garage() {}

    public JunctionTable_Car_Garage(int garageId, int carId){
        this.carId = carId;
        this.garageId = garageId;
    }

    public int getId() {
        return id;
    }

    public int getCarId() {
        return carId;
    }

    public int getGarageId() {
        return garageId;
    }
}

