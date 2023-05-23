package com.example;
import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String licensePlate;
    private double price;
    private int owner;
    private int image;
    @Column(name = "manufacturing_year")
    private int year;
    public Car(){}
    public Car(String licensePlate, double price, int year , int owner, int image) {
        this.licensePlate = licensePlate;
        this.price = price;
        this.year = year;
        this.owner = owner;
        this.image = image;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public int getOwner() { return owner; }

    public int getImage() {
        return image;
    }
    public void setImage(int image) { this.image = image; }
}
