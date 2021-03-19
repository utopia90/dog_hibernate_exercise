package com.example.util.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bone")
public class Bone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria tipo Long")
    @Column(name = "id")
    private Long id;

    @ApiModelProperty("Clave material tipo String")
    private String material;

    @ApiModelProperty("Clave isDisinfectated tipo String")
    private Boolean Disinfectated;

    @Where(clause = "is_vaccinated = 1")
    @OrderBy("name")
    @OneToMany(mappedBy = "bone")
    private List<Dog> dogs = new ArrayList<>();

    public Bone() {
    }

    public Bone(String material, Boolean disinfectated) {
        this.material = material;
        Disinfectated = disinfectated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Boolean getDisinfectated() {
        return Disinfectated;
    }

    public void setDisinfectated(Boolean disinfectated) {
        Disinfectated = disinfectated;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public String toString() {
        return "Bone{" +
                "id=" + id +
                ", material='" + material + '\'' +
                ", Disinfectated=" + Disinfectated +
                '}';
    }
}
