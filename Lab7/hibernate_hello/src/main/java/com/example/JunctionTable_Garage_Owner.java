package com.example;

import javax.persistence.*;

@Entity
@Table(name = "JunctionTable_Garage_Owner")
public class JunctionTable_Garage_Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int garageId;
    private int ownerId;

    public JunctionTable_Garage_Owner() {}

    public JunctionTable_Garage_Owner(int garageId, int ownerId){
        this.garageId = garageId;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public int getGarageId() {
        return garageId;
    }

    public int getOwnerId() {
        return ownerId;
    }

}
