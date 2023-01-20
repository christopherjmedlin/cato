package xyz.christophermedlin.cato.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Ingredient {
    private @Id @GeneratedValue Long id;
    private String name;

    public Ingredient() {
        this.name = name;
    }
    public Ingredient(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
