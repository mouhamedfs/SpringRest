package com.demo.demo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class Personne {

    public UUID getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    private final UUID id;
    @NonNull
    private final String nom;

    public Personne(@JsonProperty("id") UUID id,
                    @JsonProperty("nom") String nom) {
        this.id = id;
        this.nom = nom;
    }
}
