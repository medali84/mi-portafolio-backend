package com.factoria.f5.miportafoliospring.domain.models;

import jakarta.persistence.*;


import java.sql.Blob;
import java.util.Base64;

@Entity
@Table(name="projects")

public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String technology;

    @Column(length = 1000)
    private String description;

    @Column
    private String imagePath;

    public Proyecto() {
    }

    public Proyecto(Integer id, String name, String technology, String description, String imagePath) {
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Proyecto(String name, String technology, String description, String imagePath) {
        this.name = name;
        this.technology = technology;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
