package com.example.util.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "veterinarian")
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria tipo Long")
    private Long id;

    @ApiModelProperty("Clave nombre tipo String")
    private String name;

    @ApiModelProperty("Clave direccion tipo String")
    private String direction;

    @ApiModelProperty("Clave disponibilidad tipo Boolean")
    private Boolean availability;

    @OneToOne(mappedBy = "veterinarian")
    private Dog dog;

    public Veterinarian() {
    }

    public Veterinarian(String name, String direction, Boolean availability) {
        this.name = name;
        this.direction = direction;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", availability='" + availability + '\'' +
                ", dog=" + dog +
                '}';
    }
}
