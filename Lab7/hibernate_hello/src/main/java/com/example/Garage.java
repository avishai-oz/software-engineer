package com.example;
import javax.persistence.*;

@Entity
@Table(name = "garage")
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private int phone_number;
    private String manager;
    public Garage(){}
    public Garage(String address, int phone_number, String manager) {
        super();
        this.address = address;
        this.phone_number = phone_number;
        this.manager = manager;
    }
    
