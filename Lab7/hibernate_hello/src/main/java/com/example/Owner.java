package com.example;

import javax.persistence.*;

@Entity
@Table(name = "Owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ownerFirstName;
    private String ownerLastName;
    private String password;
    private String email;
    private int numberOfCars;
    public Owner() {}
    Owner(String ownerFirstName, String ownerLastName, String password, String email, int numberOfCars){
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.password = password;
        this.email = email;
        this.numberOfCars = numberOfCars;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public String getEmail() {
        return email;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public String getPassword() {
        return password;
    }
}
