package com.example.apollofy.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// primero el administrador de la aplicación crea los géneros, y luego los artistas crean sus tracks y le da una lista de géneros --> en track @manytomany a géneros
@Entity
@Data
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Genre(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }
}
