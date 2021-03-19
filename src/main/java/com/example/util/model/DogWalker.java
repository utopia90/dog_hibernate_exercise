package com.example.util.model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dogwalkers")
public class DogWalker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria tipo Long")
    @Column(name = "id")
    private Long id;

    @ApiModelProperty("Clave nombre tipo String")
    @Column(name = "name")
    private String name;

    @ApiModelProperty("Clave disponibilidad tipo Boolean")
    private Boolean availability;

    @Enumerated(EnumType.STRING)
    private DogWalkerType type;

    @ElementCollection
    @CollectionTable(
            name = "dogwalker_tags",
            joinColumns = @JoinColumn(name = "id_dogwalker")
    )
    private List<String> tags = new ArrayList<>();

    @ElementCollection
    private List<DogWalkerType> dogWalkerTypes = new ArrayList<>();

    public DogWalker() {
    }

    public DogWalker(String name, Boolean availability, DogWalkerType type) {
        this.name = name;
        this.availability = availability;
        this.type = type;
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

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public DogWalkerType getType() {
        return type;
    }

    public void setType(DogWalkerType type) {
        this.type = type;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<DogWalkerType> getDogWalkerTypes() {
        return dogWalkerTypes;
    }

    public void setDogWalkerTypes(List<DogWalkerType> dogWalkerTypes) {
        this.dogWalkerTypes = dogWalkerTypes;
    }

    @Override
    public String toString() {
        return "DogWalker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", availability=" + availability +
                '}';
    }
}
