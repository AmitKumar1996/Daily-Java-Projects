package com.amit.CrudAmit.entity;

import jakarta.persistence.*;

@Entity
@Table
public class ipl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Name;
    private String roll;



}
