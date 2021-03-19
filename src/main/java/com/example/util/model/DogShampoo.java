package com.example.util.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="dog_shampoo")
public class DogShampoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria tipo Long")
    private Long id;

    private String brand;
    private String Properties;


    public DogShampoo() {
    }

    public DogShampoo(String brand, String properties) {
        this.brand = brand;
        Properties = properties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProperties() {
        return Properties;
    }

    public void setProperties(String properties) {
        Properties = properties;
    }

    @Override
    public String toString() {
        return "DogShampoo{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", Properties='" + Properties + '\'' +
                '}';
    }
}
