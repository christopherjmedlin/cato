package xyz.christophermedlin.cato.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Smoothie {
    private @Id @GeneratedValue Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "smoothie_uses")
    Set<Ingredient> ingredients;

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
