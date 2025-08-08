package com.wipro.model;

import javax.persistence.*;

@Entity
@Table(name = "PAN")
public class Pan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String panholderName;
    private String panNumber;

    public Pan() {}

    public Pan(String panholderName, String panNumber) {
        this.panholderName = panholderName;
        this.panNumber = panNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPanholderName() {
        return panholderName;
    }

    public void setPanholderName(String panholderName) {
        this.panholderName = panholderName;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }
}
