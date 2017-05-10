package com.codecool.model;

import javax.persistence.*;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String token;

    private Device() {}

    public Device(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
