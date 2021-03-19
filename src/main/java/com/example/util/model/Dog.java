package com.example.util.model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria tipo Long")
    @Column(name = "id")
    private Long id;

    @ApiModelProperty("Clave nombre tipo String")
    @Column(name = "name")
    private String name;

    @ApiModelProperty("Clave dueño tipo String")
    @Column(name = "owner")
    private String owner;

    @ApiModelProperty("Clave raza tipo String")
    @Column(name = "race")
    private String race;

    @ApiModelProperty("Clave isVaccinated tipo Boolean")
    @Column(name = "is_vaccinated")
    private boolean isVaccinated;

    @ApiModelProperty("Clave edad tipo Integer")
    @Column(name = "age")
    private Integer age;


    @OneToOne
    @JoinColumn(name = "id_veterinarian") // nueva columna
    private Veterinarian veterinarian;

    @ManyToMany
    @JoinTable(
            name = "dog_dogwalker",
            joinColumns = {@JoinColumn(name = "dog_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "dogwalker_id", referencedColumnName = "id")}
    )
    private List<DogWalker> dogWalkers = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_bone")
    private Bone bone;

    @OneToMany
    @JoinTable(
            name = "dog_dog_shampoo",
            joinColumns = @JoinColumn(name = "dog_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="shampoos_id", referencedColumnName = "id")
    )
    private List<DogShampoo> dogShampoos = new ArrayList<>();



    public Dog() {
    }

    public Dog(String name, String owner, String race, boolean isVaccinated, Integer age) {
        this.name = name;
        this.owner = owner;
        this.race = race;
        this.isVaccinated = isVaccinated;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public List<DogWalker> getDogWalkers() {
        return dogWalkers;
    }

    public void setDogWalkers(List<DogWalker> dogWalkers) {
        this.dogWalkers = dogWalkers;
    }

    public Bone getBone() {
        return bone;
    }

    public void setBone(Bone bone) {
        this.bone = bone;
    }

    public List<DogShampoo> getDogShampoos() {
        return dogShampoos;
    }

    public void setDogShampoos(List<DogShampoo> dogShampoos) {
        this.dogShampoos = dogShampoos;
    }

    @Override
    public String toString() {
        return "Dog{" +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", race='" + race + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", age=" + age+
                '}';
    }


}
