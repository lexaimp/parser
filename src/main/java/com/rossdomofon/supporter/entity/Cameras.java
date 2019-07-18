package com.rossdomofon.supporter.entity;

import javax.persistence.*;

@Entity
@Table(name = "cameras")
public class Cameras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public Cameras() {

    }
}
