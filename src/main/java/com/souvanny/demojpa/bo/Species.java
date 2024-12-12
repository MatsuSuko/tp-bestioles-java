package com.souvanny.demojpa.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "common_name", nullable = false)
    private String commonName;

    @Column(name = "latin_name", nullable = false)
    private String latinName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    @Override
    public String toString() {
        return "Species{id=" + id + ", commonName='" + commonName + "', latinName='" + latinName + "'}";
    }

}
