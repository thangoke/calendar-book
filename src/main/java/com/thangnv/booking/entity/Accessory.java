package com.thangnv.booking.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "accessory")
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="uuid-char")
    @Column(name="id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private String id;
}
