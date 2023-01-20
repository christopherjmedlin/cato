package xyz.christophermedlin.cato.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Smoothie {
    private @Id @GeneratedValue Long id;
    private String name;

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
