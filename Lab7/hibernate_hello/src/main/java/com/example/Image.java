package com.example;
import javax.persistence.*;

@Entity
@Table(name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    private int carID;
    public Image() {}

    public Image(String url, int carID) {
        this.url = url;
        this.carID = carID;
    }

    public int getId() {
        return id;
    }

    public int getCarID() {
        return carID;
    }
}
